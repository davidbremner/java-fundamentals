package labs_examples.conditions_loops.labs;

import java.util.Scanner;

/**
 * Conditions and Loops Exercise 7: First vowel
 *
 *      Take in a word from the user and using a "while" loop, find the first vowel in the word.
 *      Once you find the vowel, print out the word and the first vowel.
 *
 *      Hints:
 *          - there are a few helpful methods in the String class called length(), charAt() and indexOf()
 *          - you'll likely want to use a String that contains all the vowels:
 *              - ie: String vowels = "aeiou";
 *
 */

public class Exercise_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Give me a word: ");
        String userInput = scan.next();
        String output = findFirstVowel(userInput);
        if (output.length() > 1) {
            System.out.println(output + " " + userInput);
        } else {
            System.out.println("The first vowel in " + userInput + " is " + output);
        }
    }

    public static String findFirstVowel(String word) {
        int counter = 0;
        while(counter < word.length()) {
            char isVowel = word.charAt(counter);
            if (isVowel == 'a' || isVowel == 'e' || isVowel == 'i' || isVowel == 'o' || isVowel == 'u') {
                return Character.toString(isVowel);
            }
            counter++;
        }
        return "No vowels present in word";
    }
}
