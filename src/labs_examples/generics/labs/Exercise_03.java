package labs_examples.generics.labs;

import java.util.*;

/**
 * Generics Exercise 3:
 *
 *      1) Write a generic method that accepts two generic arguments. This generic method should only accept
 *      arguments which are sublasses of Number. The generic method must return the sum (as a double) of whatever two
 *      numbers were passed in regardless of their type.
 *
 *      2) Write a generic method to count the number of elements in a "Collection" of Strings that are palindromes

 *      3) Write a generic method to exchange the positions of two different elements in an array.
 *
 *      4) Write a generic method to find the largest element within the range (begin, end) of a list.
 *
 */

class VariousGenerics {
    static <S extends Number, U extends Number> double sumOfAll(S numOne, U numTwo) {
        return numOne.doubleValue() + numTwo.doubleValue();
    }

    static <T> void palindromeCount(Collection<T> words) {
        int counter = 0;
        for (T word : words) {
            if (isPalindrome(word.toString())) {
                System.out.println(word + " is a palindrome.");
                counter++;
            }
        }
        System.out.println("Number of palindromes found: " + counter);
    }

    private static boolean isPalindrome(String word) {
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != word.charAt((word.length() - i) - 1)) {
                System.out.println(word + " is not a palindrome.");
                return false;
            }
        }
        return true;
    }

     static <T> void positionSwap(ArrayList<T> array) {
        System.out.println(array);
        int max = array.size();
        int indexOne = new Random().nextInt(max);
        int indexTwo = new Random().nextInt(max);
        T elementOne = array.get(indexOne);
        T elementTwo = array.get(indexTwo);
        array.set(indexOne, elementTwo);
        array.set(indexTwo, elementOne);
        System.out.println(array);
    }

    static <T extends Comparable<? super T>> void findLargestElement(List<T> theList) {
        int begin = 0;
        int end = theList.size() - 1;
        T largestElement = theList.get(begin);
        for (int i = 1; i <= end; i++) {
            T currentElement = theList.get(i);
            if (currentElement.compareTo(largestElement) > 0) {
                largestElement = currentElement;
            }
        }
        System.out.println("The largest element in the list is: " + largestElement);
    }
}

class Main {
    public static void main(String[] args){
        // Task 1:
        System.out.println(VariousGenerics.sumOfAll(1, 2));
        System.out.println(VariousGenerics.sumOfAll(1.1, 2.2));

        // Task 2:
        Collection<String> strings = List.of("Race", "RaceCar", "racE", "racecar", "racecar");
        VariousGenerics.palindromeCount(strings);

        // Task 3:
        ArrayList<String> anArray = new ArrayList<>();
        anArray.add("hello");
        anArray.add("there");
        anArray.add("whats");
        anArray.add("up");
        VariousGenerics.positionSwap(anArray);

        ArrayList<Integer> anotherArray = new ArrayList<>();
        anotherArray.add(1);
        anotherArray.add(2);
        anotherArray.add(3);
        anotherArray.add(4);
        VariousGenerics.positionSwap(anotherArray);

        // Task 4:
        List<Integer> myList = List.of(1, 2, 3, 5, 6, 3, 2);
        VariousGenerics.findLargestElement(myList);
    }
}