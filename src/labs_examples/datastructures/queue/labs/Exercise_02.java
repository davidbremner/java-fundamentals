package labs_examples.datastructures.queue.labs;

import java.util.Arrays;

/**
 *      Queues - Exercise_02
 *
 *      Write a new custom (Generic) Queue class that uses a traditional Array as the underlying data structure
 *      rather than the LinkedList as in the example we have already seen.
 *
 *      Your custom Queue class must also do the following:
 *
 *      1) throw a custom exception when trying to pop  an element from an empty Queue - DONE
 *      2) resize the Queue (the underlying array) to be twice the size when the Queue is more than 3/4 full - DONE
 *      3) resize the Queue (the underlying array) to be half the size when the Queue is more than 1/4 empty - DONE
 *      4) contain the methods peekFirst() and peekLast() - DONE
 *      5) contain a size() method - DONE
 *      6) contain a method to print out the data of all elements in the Queue - DONE
 *
 */

class Exercise_02 {
    public static void main(String[] args){
        GetQueuing<Integer> davesQueuing = new GetQueuing<>();
        System.out.println("Array size check: ");
        davesQueuing.printData();
        davesQueuing.add(1);
        System.out.println("\nArray size check: ");
        davesQueuing.printData();
        davesQueuing.add(2);
        System.out.println("\nArray size check: ");
        davesQueuing.printData();
        davesQueuing.add(3);
        System.out.println(davesQueuing.add(4));
        System.out.println("\nPoll to retrieve front of queue and remove: " + davesQueuing.poll());
        davesQueuing.printData();
        System.out.println("Peek front: " + davesQueuing.peekFront());
        System.out.println("Peek back: " + davesQueuing.peekBack());
        System.out.println("Queue size: " + davesQueuing.size());
    }
}

class GetQueuing<T> {
    T[] data;

    @SuppressWarnings("unchecked")
    public GetQueuing() {
        this.data = (T[])new Object[10];
    }

    /**
     * Removes an object from the front of the queue.
     * @return returns removed object(T).
     */
    T poll() {
        calculateListSpace();
        if (data == null) throw new NothingThereDudeException("null queue!");
        T frontOfQueue = data[0];

        for (int i = 0; i <= data.length; i++) {
            if (data[i + 1] == null) {
                data[i] = null;
                break;
            }
            data[i] = data[i + 1];
            }
        return frontOfQueue;
    }

    /**
     * Adds an object to the back of the queue.
     * @param dataObj the generic object to be added to the back of the queue.
     * @return returns true if the object was added to the queue, otherwise false.
     */
    boolean add(T dataObj) {
        calculateListSpace();
        boolean flag = false;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null){
                data[i] = dataObj;
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * Checks the element at the front of the queue.
     * @return returns the object(T) at the front of the queue (first in the array).
     */
    T peekFront() {
        return data[0];
    }

    /**
     * Checks the element at the back of the queue.
     * @return returns the object(T) at the back of the queue (last in the array).
     */
    T peekBack() {
        if (data == null) return null;
        for (int i = 0; i < data.length; i++) if (data[i + 1] == null) return data[i];
        return null; // never will hit but needed to compile...
    }

    /**
     * Checks how many elements are in the queue (Note: Not how many elements in the list)
     * @return returns int value of the size of the queue.
     */
    int size() {
        int elementCounter = 0;
        for (T element : data) if (element != null) elementCounter++;
        return elementCounter;
    }

    /**
     * Prints a String to the console of all elements in the list.
     */
    void printData() {
        for (T element : data) if (element != null) System.out.println(element);
        System.out.println(Arrays.toString(data)); // to visualise empty elements
    }

    /**
     * Calculates how much space (null elements) that are in the queue list.
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
     * If there is less than 25% of space available in the queue then the list must be increased otherwise decrease
     * the unnecessary space.
     * @param nullCount int of total null elements in the queue.
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
     * Doubles the queue element size.
     */
    private void increaseListSize() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    /**
     * Decreases the empty elements by half.
     * @param spaceAvailable int value of how many null elements in the queue, i.e. space available in the queue.
     */
    private void decreaseListSize(int spaceAvailable) {
        data = Arrays.copyOf(data, data.length - (spaceAvailable / 2));
    }
}

class NothingThereDudeException extends RuntimeException {
    public NothingThereDudeException() {
        super();
    }

    /**
     * Constructs a NothingThereDudeException, saving a reference to the error message string 's'
     * for later retrieval by the getMessage method.
     * @param s the detail message.
     */
    public NothingThereDudeException(String s) {
        super(s);
    }
}