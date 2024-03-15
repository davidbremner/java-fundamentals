package labs_examples.lambdas.labs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Lambdas Exercise 4:
 *
 *      Stream API Labs
 *
 *      1) Demonstrate the use of the range function to print out the numbers 1 through 15 (inclusive)
 *      2) Demonstrate the use of the sum function to determine the range of a set of numbers.
 *      3) Demonstrate the use of the map() function to alter each int in a List of Integers, then use the sum function
 *          to get the sum of the modified list
 *      4) Demonstrate the filter function by filtering out all Integers that are less than 10 - then use the average
 *          function to average the remaining numbers, assign this result to an int variable.
 *      5) Demonstrate the reduce() function to determine the sum of a list of Integers
 *      6) Demonstrate how to Stream a text file and print out each line
 *      7) Demonstrate how to Stream the stream_text_lab.csv file in this package. Split the lines into String arrays,
 *          then print out the element at the 1 index for each array.
 *      8) Demonstrate how to Stream the stream_text_lab.csv file in this package. Split the lines into String arrays,
 *          then print out the sum of all elements at index 2.
 *      9) Demonstrate the anyMatch() function.
 *      10) Demonstrate the allMatch() function.
 *      11) Demonstrate the collect() terminal operation to store resulting values into a List
 *      
 */

class Example {
    public static void main(String[] args) throws IOException {
        // 1)
        IntStream.range(1, 16)
                .forEach(System.out :: println);
        // 2)
        int sum = IntStream.range(1, 16)
                .sum();
        System.out.println("The total sum is: " + sum);
        // 3)
        List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        int mappedResult = myList.stream()
                .mapToInt(number -> number * 2)
                .sum();
        System.out.println("The total mapped sum is: " + mappedResult);
        // 4)
        double average = myList.stream()
                .filter(number -> number >= 10)
                .mapToInt(number -> number)
                .average()
                .orElse(0.0);
        int asInteger = (int) average;
        System.out.println("Average as int: " + asInteger);
        // 5)
        int reducedResult = myList.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum using reduced method: " + reducedResult);
        // 6)
        String textFile = "/Users/david.bremner/Documents/CodingNomads/labs/online-java-fundamentals/src/labs_examples/lambdas/labs/stream_text_lab.csv";
        try (Stream<String> fileLines = Files.lines(Paths.get(textFile))) {
            fileLines.forEach(System.out :: println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 7)
        try (Stream<String> fileLines = Files.lines(Paths.get(textFile))) {
            fileLines.sorted()
                    .map(line -> line.split(","))
                    .forEach(array -> System.out.println(array[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 8)
        try (Stream<String> fileLines = Files.lines(Paths.get(textFile))) {
            Double total = fileLines.sorted()
                    .map(line -> line.split(","))
                    .filter(array -> array.length == 3) // safety check array is 3
                    .map(array -> Double.parseDouble(array[2]))
                    .reduce(0.0, Double::sum);
            System.out.println("Total sum is: " + total);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 9)
        List<String> bands = Arrays.asList("Dylan Gossett", "John Vincent III", "Sam Fender", "Kaleo");
        boolean result = bands.stream()
                .anyMatch(band -> band.startsWith("S"));
        System.out.println("Any bands beginning with S: " + result);
        // 10)
        boolean outcome = bands.stream()
                .map(bandName -> bandName.split(" "))
                .allMatch(array -> array.length > 1);
        System.out.println("All band names are more than one word: " + outcome);
        // 11)
        Map<String, Integer> bandsLength = bands.stream()
                .filter(bandNames -> bandNames.length() <= 10)
                .collect(Collectors.toMap(name -> name, String::length));
        for (String key : bandsLength.keySet()) {
            System.out.println(key + ": Has length of: " + bandsLength.get(key));
        }

    }


}
