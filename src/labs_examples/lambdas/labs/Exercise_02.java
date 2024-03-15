package labs_examples.lambdas.labs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.*;

/**
 * Lambdas Exercise 2:
 *
 *      1) Demonstrate the use of 10 pre-built Functional Interfaces from the java.util.functions package. That's right,
 *      10 of them! You can do it! You'll know so much about them when you're done!
 *
 */
class Exercise_02 {
    public static void main(String[] args){
        // 1) BiConsumer
        BiConsumer<Integer, Integer> biConsumer = (x, y) -> System.out.println(x * y); // doesnt return value
        biConsumer.accept(3, 5);
        // 2) BiFunction
        BiFunction<String, Integer, HashMap<String, Integer>> biFunction = (key, value) -> {
            HashMap<String, Integer> hashMap = new HashMap<>();
            hashMap.putIfAbsent(key, value + 1);
            return hashMap;
        };
        System.out.println(biFunction.apply("David", 35));
        // 3) BinaryOperator
        BinaryOperator<Integer> binaryOperator = (num1, num2) -> num1 * num2; // does return value
        System.out.println(binaryOperator.apply(3, 5));
        // 4) BiPredicate
        BiPredicate<String, Integer> biPredicate = (string, length) -> string.length() == length;
        boolean isLength = biPredicate.test("David", 5);
        System.out.println(isLength);
        // 5) Consumer
        Consumer<List<String>> consumer = (name) -> name
                .stream()
                .filter(x -> x.endsWith("d"))
                .forEach(System.out :: println);
        List<String> attendees = new ArrayList<>();
        attendees.add("David");
        attendees.add("Kath");
        attendees.add("Chris");
        consumer.accept(attendees);
        // 6) DoubleBinaryOperator
        DoubleBinaryOperator doubleBinaryOperator = (numOne, numTwo) -> numOne * numTwo;
        System.out.println(doubleBinaryOperator.applyAsDouble(23.34, 53.22));
        // 7) DoubleConsumer
        DoubleConsumer doubleConsumer = radius -> {
            double pi = 3.12159;
            System.out.println(radius * radius * pi);
        };
        double radius = 5.5;
        doubleConsumer.accept(radius);
        // 8) DoubleFunction
        DoubleFunction<Integer> doubleFunction = x -> {
            double pi = 3.12159;
            return (int) radius * (int) radius * (int) pi;
        };
        Integer nonDouble = doubleFunction.apply(radius);
        System.out.println(nonDouble);
        // 9) DoublePredicate
        DoublePredicate doublePredicate = value -> value > 10;
        System.out.println(doublePredicate.test(23.3));
        System.out.println(doublePredicate.test(8.99));
        // 10) DoubleToIntFunction
        DoubleToIntFunction doubleToIntFunction = value -> (int) Math.round(value);
        double weight = 13.5; //kg
        System.out.println(doubleToIntFunction.applyAsInt(weight));
    }
}