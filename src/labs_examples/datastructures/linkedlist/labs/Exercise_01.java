package labs_examples.datastructures.linkedlist.labs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *      LinkedLists - Exercise_01
 *
 *      Demonstrate your mastery of Java's built-in LinkedList class by demonstrating the following:
 *
 *      1) create a LinkedList (from Java's libraries)
 *      2) add()
 *      3) addAll()
 *      4) addFirst()
 *      5) addLast()
 *      6) getFirst()
 *      7) getLast()
 *      8) get()
 *      9) set()
 *      10) push()
 *      11) pop()
 *      12) remove()
 *      13) contains()
 *      14) listIterator()
 *      15) clear()
 */

class Exercise_01 {
    public static void main(String[] args){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Gordon!");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(" Running");
        arrayList.add(" down");
        arrayList.add(" the");
        arrayList.add(" wing!");
        linkedList.addAll(arrayList);
        linkedList.addFirst("Anthooony ");
        linkedList.addLast(" Gordon!");
        System.out.println(linkedList.get(3));
        linkedList.set(1, " Make");
        linkedList.set(2, " the");
        linkedList.set(3, " Geordies");
        linkedList.set(4, " sing!");
        linkedList.push(" We're going to Paris! ");
        String popped = linkedList.pop();
        System.out.println(popped);
        String removed = linkedList.remove();
        System.out.println(removed);
        System.out.println(linkedList.contains(" Gordon!"));
        ListIterator<String> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        linkedList.clear();
        System.out.println(linkedList);
    }
}
