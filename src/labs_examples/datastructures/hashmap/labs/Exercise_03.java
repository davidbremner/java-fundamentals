package labs_examples.datastructures.hashmap.labs;

import java.util.*;

/**
 *      HashMaps Exercise_02
 *
 *      Create a new class that does the following:
 *
 *      1) create a LinkedList
 *      2) create a Stack
 *      3) create a Queue
 *      4) create a HashMap
 *
 *      Then, add millisecond timers before and after each data structure above and print out
 *      how long it takes for each to complete EACH the following tasks, and the total time for
 *      each data structure:
 *
 *      1) add 100 elements
 *      2) update 100 elements
 *      3) search for 100 elements
 *      4) delete 100 elements
 */

class Exercise_03 {
    public static void main(String[] args){
        int elementMax = 100;

        // LinkedList
        System.out.println("\n-----LINKEDLIST-----\n");
        LinkedList<Integer> linkedList = new LinkedList<>();
        long startLinkedList = System.currentTimeMillis();
        System.out.println(startLinkedList);
        // 1) add 100 elements
        for (int i = 0; i < elementMax; i++) {
            linkedList.add(i + 1);
        }
        // 2) update 100 elements
        for (int i = 0; i < elementMax; i++) {
            linkedList.set(i, i + 2);
        }
        // 3) search for 100 elements
        boolean found = false;
        for (int i = 0; i < elementMax; i++) {
            if (linkedList.get(i).equals(50)) {
                found = true;
                break;
            }
        }
        System.out.println("Was 50 found? " + found);
        // 4) delete 100 elements
        linkedList.clear();
        long endLinkedList = System.currentTimeMillis();
        System.out.println(endLinkedList);
        System.out.println("Time taken in milliseconds: " + (endLinkedList - startLinkedList));

        // Stack
        System.out.println("\n-----STACK-----\n");
        Stack<Integer> stack = new Stack<>();
        long startStack = System.currentTimeMillis();
        System.out.println(startStack);
        // 1) add 100 elements
        for (int i = 0; i < elementMax; i++) {
            stack.add(i + 1);
        }
        // 2) update 100 elements
        for (int i = 0; i < elementMax; i++) {
            stack.set(i, i + 2);
        }
        // 3) search for 100 elements
        boolean foundStack = false;
        for (int i = 0; i < elementMax; i++) {
            if (stack.get(i).equals(50)) {
                foundStack = true;
                break;
            }
        }
        System.out.println("Was 50 found? " + foundStack);
        // 4) delete 100 elements
        stack.clear();
        long endStack = System.currentTimeMillis();
        System.out.println(endStack);
        System.out.println("Time taken in milliseconds: " + (endStack - startStack));

        // Queue
        System.out.println("\n-----QUEUE-----\n");
        Queue<Integer> queue = new LinkedList<>();
        long startQueue = System.currentTimeMillis();
        System.out.println(startQueue);
        // 1) add 100 elements
        for (int i = 0; i < elementMax; i++) {
            queue.add(i + 1);
        }
        // 2) update 100 elements
        Queue<Integer> newQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            int newValue = queue.poll() + 1;
            newQueue.add(newValue);
        }
        // 3) search for 100 elements
        boolean foundQueue = false;
        for (int i = 0; i < elementMax; i++) {
            if (newQueue.contains(50)) {
                foundQueue = true;
                break;
            }
        }
        System.out.println("Was 50 found? " + foundQueue);
        // 4) delete 100 elements
        newQueue.clear();
        long endQueue = System.currentTimeMillis();
        System.out.println(endQueue);
        System.out.println("Time taken in milliseconds: " + (endQueue - startQueue));

        // HashMap
        System.out.println("\n-----HASHMAP-----\n");
        HashMap<String, Integer> hashMap = new HashMap<>();
        char asciiValue = 33;
        long startHashMap = System.currentTimeMillis();
        System.out.println(startHashMap);
        // 1) add 100 elements
        for (int i = 0; i < elementMax; i++) {
            hashMap.put(String.valueOf(asciiValue), i + 1);
            asciiValue++;
        }
        // 2) update 100 elements
        asciiValue = 33;
        for (int i = 0; i < elementMax; i++) {
            hashMap.put(String.valueOf(asciiValue), i + 2);
            asciiValue++;
        }
        // 3) search for 100 elements
        boolean foundHash = hashMap.containsValue(50);
        System.out.println("Was 50 found? " + foundHash);
        // 4) delete 100 elements
        hashMap.clear();
        long endHash = System.currentTimeMillis();
        System.out.println(endHash);
        System.out.println("Time taken in milliseconds: " + (endHash - startHashMap));
    }
}
