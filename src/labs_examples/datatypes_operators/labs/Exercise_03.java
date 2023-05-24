package labs_examples.datatypes_operators.labs;

/**
 * Please demonstrate the use of all arithmetic operators below. These include:
 *
 * addition, subtraction, multiplication, division and modulus
 *
 */
class ArithmeticOperators {

    public static void main(String[] args) {

        // write your code below
        int addition = 5 + 4;
        int subtraction = 10 - 4;
        float multiplication = 67.34f * 123.76f;
        char characterOne = 'z';
        char characterTwo = 'a';
        double division = (double) characterOne / (double) characterTwo;
        int modulus = 10 % 3;

        System.out.println("5 + 4 = " + addition);
        System.out.println("10 - 4 = " + subtraction);
        System.out.println("67.34 * 123.76 = " + multiplication);
        System.out.println("122 / 97 = " + division);
        System.out.println("10 % 3 = " + modulus);
    }

}
