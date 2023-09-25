package labs_examples.exception_handling.labs;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Exception Handling Exercise 2:
 *
 *      Demonstrate a try/catch with multiple catch statements.
 *
 */

class Exercise_02 {
    public static void main(String[] args){

        try {
            someMethod();
        } catch (InputMismatchException exception) {
            exception.printStackTrace();
        } catch (IndexOutOfBoundsException exception) {
            System.out.println(exception);
        } catch (Exception exception) {
            System.out.println(exception);
        }

        System.out.println("program finished");

    }

    static void someMethod() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Give me a word to throw an InputMismatchException or " +
                "give me 999 to throw IndexOutOfBoundsException: ");
        int answer = scan.nextInt();
        scan.close();
        if (answer == 999) {
            ArrayList<Integer> something = new ArrayList<>();
            something.add(answer);
            System.out.println(something.get(1));
        }
    }

}


