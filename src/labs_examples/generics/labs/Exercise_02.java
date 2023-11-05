package labs_examples.generics.labs;

/**
 * Generics Exercise 2:
 *
 *      Create a class with a generic method that takes in an ArrayList of any Numeric type and returns the sum of all
 *      Numbers in the ArrayList. Demonstrate how to call this method from the main() method.
 */
import java.util.ArrayList;

class DemoController {
    public static void main(String[] args){
        ArrayList<Double> arrayOne = new ArrayList<>();
        arrayOne.add(23.78);
        arrayOne.add(21.23);
        arrayOne.add(30.18);
        double testOne = Demo.sumOfList(arrayOne);
        System.out.println(testOne);

        ArrayList<Integer> arrayTwo = new ArrayList<>();
        arrayTwo.add(2);
        arrayTwo.add(245);
        arrayTwo.add(18);
        double testTwo = Demo.sumOfList(arrayTwo);
        System.out.println((int)testTwo);
    }
}

class Demo{
    public static <N extends Number> double sumOfList(ArrayList<N> theList) {
        double result = 0;
        for (N element : theList) {
            result += element.doubleValue();
        }
        return result;
    }
}