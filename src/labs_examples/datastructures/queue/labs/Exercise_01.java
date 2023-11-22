package labs_examples.datastructures.queue.labs;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *      Demonstrate your mastery of Java's (sun's) built-in Queue class (as seen in the import statement
 *      above) by completing the following:
 *
 *      1) instantiate a new Queue
 *      2) demonstrate the use of EVERY method in the Queue class - there are 7
 */

class Exercise_01 {
    public static void main(String[] args){
        Queue<Integer> myPrioQueue = new PriorityQueue<>();
        try {
            myPrioQueue.element();
        } catch (NoSuchElementException e) {
            System.out.println("Failure reason for element(): " + e.getMessage());
        }

        myPrioQueue.add(3);
        myPrioQueue.add(2);
        myPrioQueue.add(1);
        myPrioQueue.add(4);

        for (Integer num : myPrioQueue) {
            System.out.println(num);
        }

        System.out.println("Polled: " + myPrioQueue.poll());

        System.out.print("Possible to be offered? ");
        if (myPrioQueue.offer(33)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        System.out.println(myPrioQueue.peek());

        for (Integer num : myPrioQueue) {
            System.out.println(num);
        }

        try {
            myPrioQueue.remove();
            myPrioQueue.remove();
            myPrioQueue.remove();
            myPrioQueue.remove();
            myPrioQueue.remove();
        } catch (NoSuchElementException e) {
            System.out.println("Reason to not be removed: " + e.getMessage());
        }

    }
}
