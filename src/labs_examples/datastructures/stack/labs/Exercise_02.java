package labs_examples.datastructures.stack.labs;

import java.util.Arrays;

/**
 *      Stacks - Exercise_02
 *
 *      Write a new custom (Generic) Stack class that uses a traditional Array as the underlying data structure
 *      rather than the LinkedList as in the example we have already seen.
 *
 *      Your custom Stack class must also do the following: (Ryan Take 2)
 *
 *      1) throw a custom exception when trying to pop an element from an empty Stack - DONE
 *      2) resize the Stack (the underlying array) to be twice the size when the Stack is more than 3/4 full - DONE
 *      3) resize the Stack (the underlying array) to be half the size when the Stack is more than 1/4 empty - DONE
 *      4) contain the methods peekFirst() and peekLast() - DONE
 *      5) contain a size() method - DONE
 *      6) contain a method to print out the data of all elements in the Stack - DONE
 *
 *      TIP: To initialize a new array of a Generic type you can use this:
 *           T[] data = (T[]) new Object[10];
 */

class Exercise_03 {
    public static void main(String[] args){
        DavesStacked<Integer> davesStacked = new DavesStacked<>();
        davesStacked.printData();
        System.out.println(davesStacked.pop());
        System.out.println("Added: " + davesStacked.add(55));
        davesStacked.printData();
        davesStacked.add(44);
        davesStacked.add(33);
        davesStacked.add(22);
        davesStacked.add(11);
        davesStacked.add(22);
        davesStacked.printData();
        System.out.println("Popped: " + davesStacked.pop());
        davesStacked.printData();
        System.out.println("Peeking First: " + davesStacked.peekFirst());
        System.out.println("Peeking Last: " + davesStacked.peekLast());
        System.out.println("Size: "  + davesStacked.size());
    }
}

class DavesStacked<T> {
    private T[] data;
    @SuppressWarnings("unchecked")
    public DavesStacked() {
        this.data = (T[]) new Object[10];
    }

    /**
     * Remove an object from the top of the stack.
     * @return returns removed element.
     */
    T pop() {
        if (data[0] == null) return null; // break early if an empty list
        int counter = 0;
        for (T object : data) {
            if (object == null) {
                counter -= 1; // bring the index back to the previous element
                break;
            }
            counter++;
        }
        T removedElement = data[counter];
        data[counter] = null;
        return removedElement;
    }

    /**
     * Adds an object to the top of the stack.
     * @param dataObj the generic object to be added to the stack.
     * @return returns the object that was added to the stack.
     */
    T add(T dataObj) {
        calculateListSpace();
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = dataObj;
                break;
            }
        }
        return dataObj;
    }

    /**
     * Calculates how much space (null elements) that are in the stack list.
     */
    private void calculateListSpace() {
        int nullCount = 0;
        for (T object : data) {
            if (object == null) {
                nullCount++;
            }
        }
        calculatePercentageAvailable(nullCount);
    }

    /**
     * Calculates the percentage of how much empty space (null elements) there are.
     * If there is less than 25% of space available in the stack then the list must be increased otherwise decrease
     * the unnecessary space.
     * @param nullCount int of total null elements in the stack.
     */
    private void calculatePercentageAvailable(int nullCount) {
        int percentageThreshold = 25; // 25%
        int listLength = data.length;
        double percentageAvailable = ((double) nullCount / listLength) * 100;
        if (percentageAvailable < percentageThreshold) {
            increaseListSize();
        } else {
            decreaseListSize(nullCount);
        }
    }

    /**
     * Doubles the stack element size.
     */
    private void increaseListSize() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    /**
     * Decreases the empty elements by half.
     * @param spaceAvailable int value of how many null elements in the stack, i.e. space available in the stack.
     */
    private void decreaseListSize(int spaceAvailable) {
        data = Arrays.copyOf(data, data.length - (spaceAvailable / 2));
    }

    /**
     * Checks the element at the bottom of the stack.
     * @return returns the object(T) at the bottom of the stack.
     */
    T peekFirst() {
        return data[0];
    }

    /**
     * Checks the element at the top of the stack.
     * @return returns the object(T) at the top of the stack.
     */
    T peekLast() {
        int counter = 0;
        for (T element : data) {
            if (element == null) {
                counter -= 1; // bring index back 1 to correct element
                break;
            }
            counter++;
        }
        return data[counter];
    }

    /**
     * Checks how many elements are in the stack (Note: Not how many elements in the list)
     * @return returns int value of the size of the stack.
     */
    int size() {
        int length = 0;
        for (T element : data) {
            if (element == null) break;
            length++;
        }
        return length;
    }

    /**
     * Prints a String to the console of all elements in the list.
     */
    void printData() {
        System.out.println(Arrays.toString(data));
    }

}
