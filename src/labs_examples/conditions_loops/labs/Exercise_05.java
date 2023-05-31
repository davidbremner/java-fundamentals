package labs_examples.conditions_loops.labs;

import java.util.Scanner;

/**
 * Conditions and Loops Exercise 5: Calculator
 *
 *      Take two numbers from the user, an upper and lower bound. Using a "for-loop", calculate the sum
 *      of numbers from the lower bound to the upper bound. Also, calculate the average of numbers.
 *      Print the results to the console.
 *
 *      For example, if a user enters 1 and 100, the output should be:
 *
 *      The sum is: 5050
 *      The average is: 50.5
 *
 *
 */

public class Exercise_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me an upper bound number: ");
        int upperVal = scanner.nextInt();
        System.out.println("Give me a lower bound number: ");
        int lowerVal = scanner.nextInt();
        int sumNumbers = calculateSum(upperVal, lowerVal);
        double average = calculateAverage(sumNumbers, upperVal);
        System.out.println("The sum is: " + sumNumbers);
        System.out.println("The average is: " + average);
    }

    public static int calculateSum(int upperVal, int lowerVal) {
        int sum = 0;
        for(; lowerVal <= upperVal; lowerVal++) {
            sum += lowerVal;
        }
        return sum;
    }

    public static double calculateAverage(int sum, int upperValue) {
        return sum / upperValue;
    }
}
