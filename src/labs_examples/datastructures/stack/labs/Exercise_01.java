package labs_examples.datastructures.stack.labs;

import java.util.Stack;

/**
 *      Demonstrate your mastery of Java's built-in Stack class by completing the following:
 *
 *      1) instantiate a new Stack
 *      2) demonstrate the use of EVERY method in the Stack class - there are 5
 */

class Exercise_01 {
    public static void main(String[] args){
        Stack<Integer> myStack = new Stack<>();
        myStack.push(1);
        myStack.push(2);
        System.out.println("pushed: " + myStack.push(3));
        System.out.println("popped: " + myStack.pop());
        myStack.push(4);
        System.out.println("peeking: " + myStack.peek());
        int objectLocation = myStack.search(1);
        System.out.println("searching for number 1: " + objectLocation);
        System.out.println("is empty: " + myStack.empty());
    }

}