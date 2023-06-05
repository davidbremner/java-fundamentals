package labs_examples.arrays.labs;

/**
 *  2D Array
 *
 *      Creat and populate a 5x5 2D array with multiples of 3, starting with 3. Once populated, print out the results.
 *
 *      The output should look something like this:
 *
 *      3 6 9 12 15
 *      18 21 24 27 30
 *      ...
 *      ...
 *      ...
 *
 */

public class Exercise_03 {

    public static void main(String[] args) {
        int[][] twoDArray = createTwoDArray(5);
        printTwoDArray(twoDArray);
    }

    private static int[][] createTwoDArray(int size) {
        int[][] twoDArray = new int[size][size];
        int counter = 0;
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                counter++;
                twoDArray[row][col] = counter * 3;
            }
        }
        return twoDArray;
    }

    private static void printTwoDArray(int[][] twoDArray) {
        for(int[] row : twoDArray) {
            for(int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
