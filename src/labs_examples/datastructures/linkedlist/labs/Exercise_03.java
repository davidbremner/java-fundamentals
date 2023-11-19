package labs_examples.datastructures.linkedlist.labs;

/**
 *      LinkedLists - Exercise_02
 *
 *      Please create your own custom doubly-LinkedList from start to finish :) You got this!
 */

class Exercise_03 {
    public static void main(String[] args){
        LinkedListDoubly<Integer> myDoublyList = new LinkedListDoubly<>(1);
        myDoublyList.addLast(3);
        myDoublyList.removeFirst();
        myDoublyList.addFirst(2);
        myDoublyList.addFirst(1);
        myDoublyList.removeLast();
        System.out.println("Contains 2? " + myDoublyList.contains(5));
        myDoublyList.clear(-1);

    }
}

class LinkedListDoubly<E> {
    NodeDoubly<E> head;
    public LinkedListDoubly(E data) {
        this.head = new NodeDoubly<>(data);
    }

    void removeFirst() {
        head = head.next;
        head.previous = null;
    }

    /**
     * Removes a Node from the end of the list.
     * Process: Iterates through the list checking the next Node's next variable to check if it is null and therefore
     * the last Node of the list, consequently replacing the penultimate Node's next variable with null.
     */
    void removeLast() {
        NodeDoubly<E> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    /**
     * Adds a new Node to the beginning of the list.
     * Process: Replaces the head Node with the newly created Node, linking the new Nodes next to the old head Node via
     * the next instance variable and the old head Node's previous instance variable with the new head Node.
     * @param data data for the head of the new list
     */
    void addFirst(E data) {
        head = new NodeDoubly<>(head, data);
        head.next.previous = head;
    }

    /**
     * Adds a new Node to the end of the list.
     * Process: Iterates through the LinkedList till it reaches the last linked Node class.
     * the last Node of the list, thus replacing the new Node's next variable with null.
     * @param data the data for the new node
     */
    void addLast(E data) {
        NodeDoubly<E> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new NodeDoubly<>(data, current);
    }

    /**
     * Clears the old list and begins a new one!
     * @param data data for the head of the new list
     */
    void clear(E data) {
        head = new NodeDoubly<>(data);
    }

    /**
     * Takes input of data and checks to see if it is in the list.
     * Process: Iterates through the list while checking if the current Nodes data variable equals that of the data
     * variable that was passed to the method.
     * @param data the data to check if it is in the list.
     * @return boolean of true or false if the data passed to the method is found in one of the Nodes.
     */
    boolean contains(E data) {
        NodeDoubly<E> current = head;
        while (current != null) {
            if (current.data.equals(data)) return true;
            if (current.next == null) return false;
            current = current.next;
        }
        return false;
    }
}

class NodeDoubly<E> {
    E data;
    NodeDoubly<E> next;
    NodeDoubly<E> previous;
    public NodeDoubly(E data) {
        this.data = data;
    }
    public NodeDoubly(NodeDoubly<E> next, E data) {
        this.next = next;
        this.data = data;
    }
    public NodeDoubly(E data, NodeDoubly<E> previous) {
        this.data = data;
        this.previous = previous;
    }
    public NodeDoubly(E data, NodeDoubly<E> next, NodeDoubly<E> previous) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }
}
