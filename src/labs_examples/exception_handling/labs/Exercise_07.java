package labs_examples.exception_handling.labs;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Exception Handling Exercise 7:
 *
 *      1) Create a custom exception.
 *      2) Demonstrate a method throwing your custom exception.
 */

class Exercise_07 {
    public static void main(String[] args) {
        try {
            someOtherMethod();
        } catch (InputMismatchException exception) {
            System.out.println("Must be a number inputted. Exception message: " + exception);
        } catch (UnderAgeException exception) {
            System.out.println(exception);
        }
    }

    static void someOtherMethod() throws UnderAgeException, InputMismatchException {
        Scanner scan = new Scanner(System.in);
        System.out.println("How old are you? ");
        int userAnswer = scan.nextInt();
        scan.close();
        someMethod(userAnswer);
    }

    static void someMethod(int answer) throws UnderAgeException {
        if (answer >= 18) {
            System.out.println("You can travel by yourself as you are " + answer + " years old.");
        } else {
            throw new UnderAgeException("Must be over 18 to travel solo. Age given: " + answer);
        }
    }
}

class UnderAgeException extends Exception {
    public UnderAgeException (String message) {
        super(message);
    }
    @Override
    public String toString() {
        return "Encountered an UnderAgeException: {" + getMessage() + "}";
    }

}