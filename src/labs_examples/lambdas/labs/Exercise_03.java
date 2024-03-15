package labs_examples.lambdas.labs;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Lambdas Exercise 3:
 *
 *      1) Demonstrate the use of a static method reference
 *      2) Demonstrate the use of an instance method reference
 *      3) Demonstrate the use of a constructor reference
 *
 */

class Exercise_03 {
    public static void main(String[] args){
        // 1)
        String[] teams = {"Newcastle United", "Sunderland", "Middlesbrough"};
        System.out.println("Before sorting: " + Arrays.toString(teams));
        Arrays.sort(teams, String :: compareToIgnoreCase);
        System.out.println("After sorting: " + Arrays.toString(teams));
        // 2)
        Exercise_03 exercise03 = new Exercise_03();
        UnaryOperator<String[]> unaryOperator = exercise03 :: reverse;
        String[] reversedTeams = unaryOperator.apply(teams);
        System.out.println("After instance method: " + Arrays.toString(reversedTeams));
        // 3)
        Supplier<Exercise_03> supplier = Exercise_03 :: new;
        Exercise_03 newClass = supplier.get();
        System.out.println("String created by default constructor: " + newClass);
    }

    String[] reverse(String[] array) {
        int index = array.length - 1;
        String[] newArray = new String[array.length];
        for (String word : array) {
            newArray[index] = word;
            index--;
        }
        return newArray;
    }
}