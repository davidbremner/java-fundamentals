package labs_examples.arrays.labs;

/**
 *  Irregular Arrays
 *
 *      Create and populate a 2 dimensional irregular array of size and contents of your choosing. Using a nested
 *      "for-each" loop, iterate and print out each element of the array.
 *
 */

public class Exercise_04 {
    public static void main(String[] args){
        int[][] irregArray = {
                {11, 12, 13},
                {21, 22, 23, 24},
                {31, 32, 33, 34, 35}
        };
        printArray(irregArray);
    }

    private static void printArray(int[][] array) {
        for(int[] row : array) {
            for(int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
