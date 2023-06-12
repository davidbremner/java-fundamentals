package labs_examples.objects_classes_methods.labs.methods;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class Exercise_01 {

    public static void main(String[] args) {

        // please create the methods as instructed below then
        // call each of those methods from here, within the main()
        int multiplication = multiply(5, 10);
        double division = divide(10, 3);
        printJoke();
        int years = yearsInSeconds(5);
        int lengthArray = lengthOfVarargs("Hello", "there", "sunshine");
        System.out.println("Multiplication: " + multiplication);
        System.out.println("Division: " + division);
        System.out.println("Seconds in years: " + years);
        System.out.println("The length of the varargs array: " + lengthArray);
    }


    // 1) Create a static multiply() method below that takes two int arguments (int a, int b) and
    //    returns the result of a * b

    /**
     * Returns the result of multiplying two integers
     * @param a the first integer to be multiplied
     * @param b the second integer to be multiplied
     * @return the product of the two integers
     */
    static int multiply(int a, int b) {
        return a * b;
    }


    // 2) Create a static divide() method below that takes two int arguments (int a, int b) and
    //    returns the result of a / b

    /**
     * Returns the result of dividing two integers
     * @param a the first integer to be divided
     * @param b the second integer to be divided
     * @return the product of the two integers being divided and returned as a double data value
     */
    static double divide(int a, int b) {
        return (double) a / b;
    }


    // 3) Create a static void method that will print of joke of your choice to the console

    /**
     * Prints out a joke
     */
    static void printJoke() {
        System.out.println("I invented a new word! ..Plagiarism!");
    }


    // 4) Create a static method that takes in a number in years (int years) as an argument
    //    and returns the number of seconds that number in years represents

    /**
     * Calculates the number of seconds represented by a given number of years.
     * @param years number of years
     * @return the number of seconds in the given number of years
     */
    static int yearsInSeconds(int years) {
        int secondsInOneYear = 365 * 24 * 60 * 60;
        return years * secondsInOneYear;
    }


    // 5) Create a varargs method that will return the length of the varargs array passed in
    static int lengthOfVarargs(String... words) {
        return words.length;
    }

}
