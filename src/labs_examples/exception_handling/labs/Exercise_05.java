package labs_examples.exception_handling.labs;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Exception Handling Exercise 5:
 *
 *      Demonstrate how to throw an exception.
 *
 */

class Exercise_05 {

    public static void main(String[] args) {
        try {
            someMethod();
        } catch (InputMismatchException exception) {
            System.out.println("Must be an int: " + exception);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("The provided index number should be 0-2: " + exception);
        }
    }

    static void someMethod() {
        int[] someNumbers = {55, 11, 32};
        Scanner scan = new Scanner(System.in);
        System.out.println("Give me an index number (0-2) to find out what number you get? ");
        int userAnswer = scan.nextInt();
        scan.close();
        if (userAnswer >= 0 && userAnswer < someNumbers.length) {
            System.out.println("Your number is: " + someNumbers[userAnswer]);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}

