package labs_examples.conditions_loops.labs;

/**
 * Conditions and Loops Exercise 10: continue
 *
 *      Demonstrate the use of the "continue" statement to skip to the next iteration of a loop.
 *
 */

public class Exercise_10 {
    public static void main(String[] args) {
        int i = 10;
        while (i > 1) {
            boolean isTrue = i % 3 == 0;
            if (isTrue) {
                i--;
                continue;
            }
            System.out.println(i);
            i--;
        }
    }
}
