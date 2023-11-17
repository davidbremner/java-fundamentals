package labs_examples.datastructures.linkedlist.labs;

/**
 *      LinkedLists - Exercise_02
 *      Write your own custom LinkedList class. Although it can mimic the CustomLinkedList
 *      class we used here, it must be entirely unique. Please also add at least two
 *      additional helper methods that you think could be useful. Refer to Java's built-in
 *      LinkedList class for inspiration. Your new LinkedList class should ONLY allow users
 *      to add and remove elements from the front of the list AND the end of the list.
 *      Also, instead of using the index in the get() and remove() methods, these methods should
 *      get() and remove() based by the Node's value, not it's index.
 */

class Exercise_02 {
    public static void main(String[] args){
        DavesLinkedList<Integer> myList = new DavesLinkedList<>(1);
        myList.addLast(2);
        myList.addLast(3);
        myList.addFirst(0);
        myList.addFirst(-1);
        System.out.println(myList.contains(99));
        myList.removeLast();
        myList.removeFirst();
        myList.clear(100);
        myList.clear(10);
        System.out.println(myList.contains(10));

    }
}

class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
        this.data = data;
    }
    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }
    public Node(){}
}

class DavesLinkedList<E> {
    Node<E> head;
    public DavesLinkedList(E data) {
        this.head = new Node<>(data);
    }

    /**
     * Adds a new Node to the end of the list.
     * Process: Iterates through the LinkedList till it reaches the last linked Node class.
     * @param data the data for the new node
     */
    void addLast(E data) {
        Node<E> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<>(data);
    }

    /**
     * Adds a new Node to the beginning of the list.
     * Process: Replaces the head Node with the newly created Node, linking this to the previous head Node.
     * @param data the data for the new node
     */
    void addFirst(E data) {
        head = new Node<>(data, head);
    }

    /**
     * Removes a Node from the end of the list.
     * Process: Iterates through the list checking the next Node's next variable to check if it is null and therefore
     * the last Node of the list, consequently replacing the penultimate Node's next variable with null.
     */
    void removeLast() {
        Node<E> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    /**
     * Removes a Node from the start of the list.
     * Process: Replaces the current head with the next Node in the list.
     */
    void removeFirst() {
        head = head.next;
    }

    /**
     * Clears the old list and begins a new one!
     * @param data data for the head of the new list
     */
    void clear(E data) {
        head = new Node<>(data);
    }

    /**
     * Takes input of data and checks to see if it is in the list.
     * Process: Iterates through the list while checking if the current Nodes data variable equals that of the data
     * variable that was passed to the method.
     * @param data the data to check if it is in the list.
     * @return boolean of true or false if the data passed to the method is found in one of the Nodes.
     */
    boolean contains(E data) {
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(data)) return true;
            if (current.next == null) return false;
            current = current.next;
        }
        return false;
    }
}