package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 1:
 *
 *      1) Demonstrate a try/catch.
 *
 */

class Exercise_01 {
    public static void main(String[] args) {

        try {
            someMethod();
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println(exception);
        }

        System.out.println("End of program");

    }

    static void someMethod() {
        int[] someNumbers = {1, 2, 3};
        System.out.println(someNumbers[3]);
    }
}


