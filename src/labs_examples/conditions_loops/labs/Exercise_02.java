package labs_examples.conditions_loops.labs;

import java.util.Scanner;

/**
 * Conditions and Loops Exercise 2: Days of the week
 *
 *      Take in a number from the user and print "Monday", "Tuesday", ... "Sunday", or "Other"
 *      if the number from the user is 1, 2,... 7, or other respectively. Use an if-else statement
 *      to accomplish this task.
 * 
 *      Bonus Tricky Challenge: Use a "nested-if" statement.
 *
 */

public class Exercise_02 {

    public static void main(String[] args) {
    
        // write completed here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me a number from 1-7 to see which day it corresponds with: ");
        String day = getDayOfWeek(scanner.nextInt());
        System.out.println(day);

    }
    public static String getDayOfWeek(int weekNum) {
        String weekDay;
        if (weekNum < 1 || weekNum > 7) {
            weekDay = "Other";
        } else {
            if (weekNum == 1) {
                weekDay = "Monday";
            } else if (weekNum == 2) {
                weekDay = "Tuesday";
            } else if (weekNum == 3) {
                weekDay = "Wednesday";
            } else if (weekNum == 4) {
                weekDay = "Thursday";
            } else if (weekNum == 5) {
                weekDay = "Friday";
            } else if (weekNum == 6) {
                weekDay = "Saturday";
            } else {
                weekDay = "Sunday";
            }
        }
        return weekDay;
    }
}
