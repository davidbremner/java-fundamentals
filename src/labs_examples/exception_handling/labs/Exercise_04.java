package labs_examples.exception_handling.labs;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Exception Handling Exercise 4:
 *
 *      Demonstrate a nested try/catch.
 *
 */

class Exercise_04 {
    public static void main (String[] args) {
        // enter a string for scanner to trigger the inner catch block, swap the numbers around to trigger the outer catch block
        int someNumberOne = 0;
        int someNumberTwo = 5;
        try {
            int result = someMethod(someNumberOne, someNumberTwo);
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("What should this number (" + result + ") be multiplied by? ");
                int answer = scan.nextInt();
                System.out.println("Answer: " + anotherMethod(result, answer));
            } catch (InputMismatchException exception) {
                System.out.println("Input needs to be an int, variable 'answer': " + exception.getMessage());
            }
        } catch (ArithmeticException exception) {
            System.out.println("Cannot divide by 0: " + exception.getMessage());
        }
        System.out.println("End of program");
    }

    static int someMethod(int a, int b) {
        return a / b;
    }

    static int anotherMethod(int result, int answer) {
        return result * answer;
    }
}
