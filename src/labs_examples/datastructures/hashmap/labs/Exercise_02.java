package labs_examples.datastructures.hashmap.labs;

/**
 *      HashMaps Exercise_02
 *
 *      Rewrite the CustomHashMap class to meet the following requirements:
 *      1) no method has the same name as any in CustomHashMap
 *          (do not use refactor - do it manually) - DONE
 *      2) no variable has the same name as any in CustomHashMap
 *          (do not use refactor - do it manually) - DONE
 *      3) resize the HashMap when the underlying array is more than half full - DONE
 *      4) triple the size of the underlying array on resize() - DONE
 *      5) instead of checking the number of keys to resize, check the number of values - Dunno what you're asking?
 *      6) on collisions, add new elements to the front of the LinkedList, not the end - DONE
 *      7) anytime someone tries to get/update/remove an element that does not exist, print
 *          out a message indicating that the element does not exist - DONE
 *      8) add at least one more method that you think could be useful to the HashMap
 *          review Java's built-in HashMap for inspiration - DONE
 */

class Controller {
    public static void main(String[] args){
        Exercise_02<String, Integer> myHash = new Exercise_02<>();
        myHash.putInMap("David", 35);
        myHash.putInMap("Clara", 29);
        myHash.putInMap("Teresa", 70);
        myHash.putInMap("Chris", 38);
        System.out.println(myHash.getStorage());
        System.out.println("Value of Teresa: " + myHash.getValue("Teresa"));
        System.out.println("Is empty? " + myHash.isEmpty());
        myHash.removeFromMap("David");
        System.out.println("Still in map 'David'? " + myHash.containsKey("David"));
        System.out.println("Still in map 'Chris'? " + myHash.containsKey("Chris"));
        myHash.clear();
        System.out.println("Still in map 'Chris'? " + myHash.containsKey("Chris"));
        System.out.println("Now empty? " + myHash.isEmpty());
    }
}
class Exercise_02<K, V> {

    // create the underlying Entry array with the initial size of 10
    private EntryNode<K, V>[] array = new EntryNode[10];

    // track the current number of elements in the hashmap
    private int numEntries = 0;


    /**
     * Hashes the given key and returns a table index
     *
     * @param key to be hashed
     * @return a table index
     */
    private int getHash(K key) {
        // get the hashCode for the key and mod that hashCode by the length of the array
        int index = Math.abs(key.hashCode() % array.length);
        // the result will be the index where we can find and/or place entries
        return index;
    }

    /**
     * Adds the key-value pair to the hashmap
     *
     * @param key   a key Object
     * @param value a value Object
     */
    public void putInMap(K key, V value) {
        // call the getHash() method to get the index to place the element
        int index = getHash(key);

        // create the Entry object containing the key and value that we will store in the underlying array
        EntryNode<K,V> entryNode = new EntryNode<>(key, value);

        // no element at the given index, means no collision
        // go ahead and simply add the value to the array
        if (array[index] == null) {
            array[index] = entryNode;
            numEntries++;
        }
        // otherwise, there was a collision
        // we need set the first entry as the new Entry at the beginning of the linked list at that index
        else {
            // get the first Entry (in the linked list) at the given index
            EntryNode<K, V> firstEntry = array[index];
            // set the new Entry as the one associated with the hash index
            array[index] = entryNode;
            // set the new Entry's next instance variable as the old firstEntry
            entryNode.setNext(firstEntry);

            numEntries++;
        }

        // check for resize
        if (numEntries > array.length * .5) {
            // the resize method will create a bigger underlying array and
            // add all values in the existing array to the new, larger array
            changeSize();
        }
    }

    /**
     * Resizes the underlying array to double its previous size and copies the old values into it
     */
    private void changeSize() {
        // make a copy of the existing table and call it "old"
        EntryNode<K, V>[] oldArray = array;
        // create a new EntryNode[] that is thrice the size of the old one
        array = new EntryNode[oldArray.length * 3];

        // iterate over the length of the old array
        for (EntryNode<K, V> kvEntryNode : oldArray) {
            try {
                // get the EntryNode at the index of "i" from the "old" table
                EntryNode<K, V> entryNode = kvEntryNode;
                // call the put() method passing the key and value to add this element to the new table
                putInMap(entryNode.getKey(), entryNode.getValue());

                // check to see if this entry is actually the start of a linked list
                while (entryNode.getNext() != null) {
                    // if it is, traverse to the next node
                    entryNode = entryNode.getNext();
                    // and call the put() method to add this element
                    putInMap(entryNode.getKey(), entryNode.getValue());
                    // loop
                }
            } catch (Exception e) {
                // do nothing - this is just to handle empty indexes
            }
        }
    }

    /**
     * Removes the pair at the given key from the hashmap
     *
     * @param key of the pair to be removed
     */
    public void removeFromMap(K key) {

        // ensure key exists by calling the get() method
        if (getValue(key) == null) {
            // if the getValue() method returns null, there's nothing to delete
            System.out.println("Unable to remove as the specified key, " + key + ", does not exist.");
            return;
        }

        // otherwise, get the index for the key by calling the hash() method
        int index = getHash(key);

        // get the EntryNode at the index
        EntryNode<K, V> entryNode = array[index];

        // if this entry has the matching key, remove the element at this index
        if (entryNode.getKey().equals(key)){
            array[index] = null;
            numEntries--;
            return;
        }

        // otherwise, if the next element in the linked list is not null
        while (entryNode.getNext() != null ) {
            // if the key of the next element in the linked list is not the key we're looking for
            if (entryNode.getNext().getKey() != key) {
                // traverse the linked list to the next node
                entryNode = entryNode.getNext();
            }
        }

        // when we exit the loop above, entry.next will contain the key we're looking for
        // if we're deleting from the middle of a linked list we need to link
        // entry.next to entry.next.next - this is basically like turning this list:
        // a -> b -> c
        // into this list:
        // a -> c
        if(entryNode.getNext().getNext() != null){
            entryNode.setNext(entryNode.getNext().getNext());
            numEntries--;
            return;
        }
        // otherwise, entry.next is the end of the list so we can just chop it off
        else {
            entryNode.setNext(null);
            numEntries--;
            return;
        }
    }

    /**
     * Finds the value of a key
     *
     * @param key to search for
     * @return value of the given key
     */
    public V getValue(K key) {
        // call the getHash() method to get the index for the key
        int index = getHash(key);

        // nothing at key - return null
        if (array[index] == null) {
            System.out.println("Unable to retrieve as the specified key, " + key + ", does not exist.");
            return null;
        }

        // otherwise, get the EntryNode at the index
        EntryNode<K, V> entryNode = array[index];

        // if the key of the current entry is not the key we're looking for
        // that means we're looking at a linked list and we need to traverse it
        // if the key does match right from the start, this loop will be skipped
        while (entryNode.getKey() != key) {

            // if we reach the end of the list and haven't found it return null
            if (entryNode.getNext() == null) {
                System.out.println("Unable to retrieve as the specified key, " + key + ", does not exist.");
                return null;
            }

            // otherwise, keep traversing the linked list
            entryNode = entryNode.getNext();
        }

        // if we get here, that means the key has been found, return the value
        return entryNode.getValue();
    }

    /**
     * For Testing: gets the size of the underlying array
     *
     * @return int storage size
     */
    public int getStorage() {
        return array.length;
    }

    /**
     * MY ADDITION
     * Checks to see if the customer hashmap is empty.
     * @return boolean if the numEntries is zero and therefore an empty hashmap.
     */
    public boolean isEmpty() {
        return numEntries == 0;
    }

    /**
     * MY ADDITION
     * Checks to if a key is in the hashmap.
     * @param key takes in a key value of type K
     * @return boolean if the key is found in the hashmap or false if it doesn't exist.
     */
    public boolean containsKey(K key) {
        for (EntryNode<K, V> kvEntryNode : array) {
            if (kvEntryNode != null && key.equals(kvEntryNode.getKey())) return true;
        }
        return false;
    }

    public void clear() {
        array = new EntryNode[10];
        numEntries = 0;
    }
}

class EntryNode<K, V> {
    private K key;
    private V value;
    private EntryNode<K, V> next = null;

    public EntryNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public EntryNode<K, V> getNext() {
        return next;
    }

    public void setNext(EntryNode<K, V> next) {
        this.next = next;
    }
}