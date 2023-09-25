package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 3:
 *
 *      Demonstrate a try/catch/finally block.
 *
 */

class Exercise_03 {
    public static void main(String[] args) {
        try {
            someMethod();
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println(exception);
        } finally{
            System.out.println("Whatever the outcome print me!");
        }
    }

    static void someMethod() {
        int[] someNumbers = {1, 2, 3, 4, 5};
        for (int i = 0; i <= (someNumbers.length + 1); i++) {
            System.out.println(someNumbers[i]);
        }
    }
}
