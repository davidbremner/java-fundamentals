package labs_examples.conditions_loops.labs;

/**
 * Conditions and Loops Exercise 6: Basic while loop
 *
 *      Use a "while" loop find the sum of numbers to from 1-100. Print the sum to the console
 *
 */

public class Exercise_06 {
    public static void main(String[] args) {
        int numLower = 50;
        int numUpper = 100;
        int sum = calculateSum(numLower, numUpper);
        System.out.println(sum);
    }

    public static int calculateSum(int numLower, int numUpper) {
        int num = 0;
        while(numLower <= numUpper) {
            num += numLower;
            numLower++;
        }
        return num;
    }
}
