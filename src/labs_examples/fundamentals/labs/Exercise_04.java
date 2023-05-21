package labs_examples.fundamentals.labs;

/**
 * Fundamentals Exercise 4: My Second Program
 *
 *      Write the necessary code to display, declare and print each of Java's primitive data types.
 *      Please declare a single variable of each type, give it an appropriate value, then print that variable.
 *
 */

public class Exercise_04 {

    public static void main(String[] args) {

        int i = 1;
        System.out.println("int i is: " + i);

        // write your code below
        short primDataType2 = 20000;
        System.out.println("Primitive data type short: " + primDataType2);

        byte primDataType3 = 127;
        System.out.println("Primitive data type byte: " + primDataType3);

        long primDataType4 = 1232346798888989567L;
        System.out.println("Primitive data type long: " + primDataType4);

        char primDataType5 = 'd';
        System.out.println("Primitive data type char: " + primDataType5);

        boolean primDataType6 = true;
        System.out.println("Primitive data type boolean: " + primDataType6);

        float primDataType7 = 3848348938498394893483493483948938490.76786f;
        System.out.println("Primitive data type float: " + primDataType7);

        double primDataType8 = 12399999999999999999994.34987788887878895667543256;
        System.out.println("Primitive data type double: " + primDataType8);
    }

}
