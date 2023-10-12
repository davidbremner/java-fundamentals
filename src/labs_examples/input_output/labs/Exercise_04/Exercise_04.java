package labs_examples.input_output.labs.Exercise_04;

import java.util.ArrayList;

/**
 *
 *      Following the video examples and source code found in the src/labs_examples/input_output/examples/csv_parser
 *      package, create a new application that will parse a custom CSV file that you created and map each line of the
 *      csv to a custom POJO that you create.
 *
 *      Then add that object to an arraylist. After you have mapped each row of the csv to objects
 *      and added each object to an arraylist, print out each object using the objects custom toString() method.
 *
 *      Then, write the arraylist of objects back out to a new .csv file. Ensure that the resulting csv file is valid.
 *
 */

public class Exercise_04 {
    public static void main(String[] args){
        ArrayList<Transaction> firstTransactions = CsvParser.csvReader("src/labs_examples/input_output/files/transactions.csv");
        System.out.println(firstTransactions);
    }
}