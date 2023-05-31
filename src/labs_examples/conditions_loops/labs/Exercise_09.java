package labs_examples.conditions_loops.labs;

/**
 * Conditions and Loops Exercise 9: break
 *
 *      Demonstrate the use of the "break" statement to exit a loop.
 *
 */

public class Exercise_09 {
    public static void main(String[] args) {
        int i = 10;
        for (; i > 1; i--) {
            System.out.println(i);
            if (i % 4 == 0) {
                break;
            }
        }
        System.out.println("Broke out of loop as the number " + i + " to the modulus of 4 equalled 0");
    }
}
