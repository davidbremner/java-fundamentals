package labs_examples.lambdas.labs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Lambdas Exercise 1:
 *      1) Demonstrate creating a functional interface with an abstract method that takes no parameters and returns void
 *      2) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *      3) Demonstrate creating a functional interface with an abstract method that takes 1 parameter and returns a
 *          value of the same type as the parameter
 *      4) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *      5) Demonstrate creating a functional interface with an abstract method that takes 2 parameters and returns a
 *          value
 *      6) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *      7) Demonstrate the use of at least two built-in functional interfaces from the java.util.function package.
 */
class Exercise_01 {
  public static void main(String[] args) {
    // 2) Implement the previous functional interface with a lambda expression and use it.
    // Also demonstrate creating an anonymous inner class from this interface.
    MyFunctionalInterface lambdaInterface = () -> System.out.println("This is my lambda!");
    lambdaInterface.myAbstractMethod();
    MyFunctionalInterface anonymousInterface =
        new MyFunctionalInterface() {
          @Override
          public void myAbstractMethod() {
            System.out.println("This is my anonymous inner class!");
          }
        };
    anonymousInterface.myAbstractMethod();

    // 4) Implement the previous functional interface with a lambda expression and use it. Also
    // demonstrate creating
    // an anonymous inner class from this interface.
    ParameterFunctionalInterface<Integer> lambdaParameterInterface =
        x -> {
          ArrayList<Integer> arrayList = new ArrayList<>();
          arrayList.add(x * x);
          arrayList.add(x + x);
          return arrayList;
        };
    ArrayList<Integer> oneParamLambda = lambdaParameterInterface.parameterAbstractMethod(5);
    System.out.println("The is the one oneParamLambda: " + oneParamLambda);
    ParameterFunctionalInterface<Integer> anonymousParameterInterface =
        new ParameterFunctionalInterface<>() {
          @Override
          public ArrayList<Integer> parameterAbstractMethod(Integer someValue) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(someValue * someValue);
            arrayList.add(someValue + someValue);
            return arrayList;
          }
        };
    ArrayList<Integer> oneParamAnonymous = anonymousParameterInterface.parameterAbstractMethod(5);
    System.out.println("The is the one oneParamAnonymous: " + oneParamAnonymous);

    // 6) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
    // an anonymous inner class from this interface.
    TwoParameterFunctionalInterface<String, Integer> lambdaTwoParameterFunctionalInterface =
            (nameAge, ageLimit) -> nameAge.keySet()
                    .stream()
                    .filter(name -> nameAge.get(name) >= ageLimit)
                    .collect(Collectors.toList());

    int gigMinimumAge = 18;
    HashMap<String, Integer> peopleAttending = new HashMap<>();
    peopleAttending.put("Dave", 35);
    peopleAttending.put("Alfie", 0);
    peopleAttending.put("Clara", 29);

    List<String> approvedAdmission =
            lambdaTwoParameterFunctionalInterface.twoParameterAbstractMethod(peopleAttending, gigMinimumAge);
    System.out.println("The following are old enough to attend the gig: " + approvedAdmission);

    TwoParameterFunctionalInterface<String, Integer> anonymousTwoParameterFunctionalInterface = new TwoParameterFunctionalInterface<String, Integer>() {
        @Override
        public List<String> twoParameterAbstractMethod(HashMap<String, Integer> map, Integer minimumLimit) {
            return map.keySet()
                    .stream()
                    .filter(name -> map.get(name) < minimumLimit)
                    .collect(Collectors.toList());
        }
    };

    List<String> deniedAdmission =
            anonymousTwoParameterFunctionalInterface.twoParameterAbstractMethod(peopleAttending, gigMinimumAge);
    System.out.println("The following are NOT old enough to attend the gig: " + deniedAdmission);

    // 7) Demonstrate the use of at least two built-in functional interfaces from the java.util.function package.
    Predicate<String> isCorrectPassword = (x) -> x.compareTo("password") == 0;
    System.out.println("Is password correct? " + isCorrectPassword.test("dunno"));
    System.out.println("Is password correct? " + isCorrectPassword.test("password"));

    Consumer<ArrayList<Integer>> filter = (x) -> x.stream()
            .map(n -> n * n)
            .filter(n -> n > 10)
            .forEach(System.out :: println);
    ArrayList<Integer> input = new ArrayList<>();
    input.add(1);
    input.add(2);
    input.add(3);
    input.add(4);
    input.add(5);
    filter.accept(input);
  }
}

// 1) Demonstrate creating a functional interface with an abstract method that takes no parameters
// and returns void
interface MyFunctionalInterface {
  void myAbstractMethod();
}

// 3) Demonstrate creating a functional interface with an abstract method that takes 1 parameter and
// returns a
// value of the same type as the parameter
interface ParameterFunctionalInterface<T> {
  ArrayList<T> parameterAbstractMethod(T someValue);
}

// 5) Demonstrate creating a functional interface with an abstract method that takes 2 parameters
// and returns a value
interface TwoParameterFunctionalInterface<K, V> {
  List<K> twoParameterAbstractMethod(HashMap<K, V> map, Integer minimumLimit);
}
