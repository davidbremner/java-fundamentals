package labs_examples.arrays.labs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *  Traversing Arrays Backwards
 *
 *      Please create and populate an array of your choosing. Then, please demonstrate how to print out every other
 *      element in the array in reverse order.
 *
 */

public class Exercise_05 {
    public static void main(String[] args){
        String[] array = {"hello", "there", "David", "whats", "up", "with", "your", "outfit"};

        String[] reversedArray = reverseArray(array);
        System.out.println(Arrays.toString(reversedArray));
        printArray(reversedArray);

    }

    private static String[] reverseArray(String[] array) {
        String[] newArray = new String[array.length];
        int i = 0;
        for(int counter = array.length; counter > 0; counter--) {
            newArray[i] = array[counter - 1];
            i++;
        }
        return newArray;
    }

    private static void printArray(String[] reversedArray) {
        int counter = 0;
        for(String element : reversedArray) {
            if(counter % 2 == 0) {
                System.out.print(element + " ");
            }
            counter++;
        }
    }

}
