package labs_examples.exception_handling;

public class TestingExceptionHandling {
    public static void main(String[] args){

        System.out.println("\n------------------------\n");

        Person person = new Person("David", 17);
        Person personTwo = new Person("Clara", 19);

        try {
            person.wine = ageCheck(person, new Wine("red"));
        } catch (AgeRestrictionException exception) {
            System.out.println(exception);
        }
        try {
            personTwo.wine = ageCheck(personTwo, new Wine("white"));
        } catch (AgeRestrictionException exception) {
            System.out.println(exception);
        }

        System.out.println(person);
        System.out.println(personTwo);
        System.out.println("End of the program");
    }

    // no code in main for methodOne & Two anymore but it is an example of handling the exception but also throwing it
    // upwards through the call stack for it to be handled at the next catch block (was the main method)
    public static void methodOne(String[] words) throws ArrayIndexOutOfBoundsException {
        methodTwo(words);
    }
    public static void methodTwo(String[] words) throws ArrayIndexOutOfBoundsException {
        try {
            for (int i = 0; i < words.length + 1; i++) {
                System.out.println(words[i]);
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Error caught in methodTwo, now throw to methodOne!");
            throw exception;
        }
    }

    public static Wine ageCheck(Person person, Wine wine) throws AgeRestrictionException {
        if (person.age >= 18) {
            return wine;
        } else {
            throw new AgeRestrictionException("Must be 21 to purchase alcohol");
        }
    }
}

class Wine {
    public String type;
    public Wine(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Wine{" +
                "type='" + type + '\'' +
                '}';
    }
}

class Person {
    public String name;
    public int age;
    public Wine wine;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", wine=" + wine +
                '}';
    }
}

class AgeRestrictionException extends Exception {

    public AgeRestrictionException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "AgeRestrictionException{ " + getMessage() + " }";
    }
}
