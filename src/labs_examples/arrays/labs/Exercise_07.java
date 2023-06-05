package labs_examples.arrays.labs;

import java.util.ArrayList;

/**
 *  ArrayLists
 *
 *      Please demonstrate how to create an ArrayList, populate an array list, access elements within an ArrayList.
 *      Also take a moment to explore the many methods that are available to you when you use an ArrayList. By simply
 *      typing the dot operator (".") after the ArrayList object that you create. You should see a menu pop up that
 *      shows a list of methods.
 *
 */
public class Exercise_07 {
    public static void main(String[] args){
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Lets");
        arrayList.add("try");
        arrayList.add("this");
        arrayList.add("out");
        for(String element : arrayList) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("The word at index 3 is: " + arrayList.get(3));
        System.out.println("The index of 'try' is: " + arrayList.indexOf("try"));
        arrayList.remove("this");
        if(arrayList.contains("out")) {
            System.out.println("The array list does contain 'out'");
        }

        ArrayList<String> arrayListTwo = new ArrayList<>();
        arrayListTwo.add("Lets");
        arrayListTwo.add("try");
        arrayListTwo.add("out");
        if(arrayList.equals(arrayListTwo)) {
            System.out.println("Both arrays are equal: " + arrayList + " & " + arrayListTwo);
        }
    }
}
