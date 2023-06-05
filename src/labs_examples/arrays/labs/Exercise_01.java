package labs_examples.arrays.labs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Arrays calculator
 *
 *      Take in 10 numbers from the user. Place the numbers in an array. Using the loop of your choice,
 *      calculate the sum of all of the numbers in the array as well as the average.
 *
 *      Print the results to the console.
 *
 */

public class Exercise_01 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Give me 10 numbers: ");
        int sum = getNumbers(10);
        System.out.println("The total sum of given numbers is: " + sum + "\nAnd the average is: " + sum / 10);
    }

    public static int getNumbers(int length) {
        int[] numList = new int[length];
        for(int i = 0; i < length; i++) {
            numList[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(numList));
        //call sumOfNumbers to calculate sum of inputted numbers and return int value to main method
        return sumOfNumbers(numList);
    }

    public static int sumOfNumbers(int[] numbers) {
        int sum = 0;
        for(int number : numbers) {
            sum += number;
        }
        //returns to getNumbers method
        return sum;
    }
}