import java.util.*;

// Node class for each element in the linked list (used for chaining)
class Node {
    int key;
    int value;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

// Hash Map class with chaining
public class MyHashMap {
    private static final int DEFAULT_CAPACITY = 10;
    private List<Node> buckets;
    private int capacity;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        buckets = new ArrayList<>(capacity);
        // Initialize each bucket with null
        for (int i = 0; i < capacity; i++) {
            buckets.add(null);
        }
    }

    // Hash function to determine index
    private int hash(int key) {
        return key % capacity;
    }

    // Insert a key-value pair into the hash map
    public void put(int key, int value) {
        int index = hash(key);
        Node head = buckets.get(index);

        // Check if key already exists, update its value
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        // Insert new node at the beginning of the linked list (chaining)
        Node newNode = new Node(key, value);
        newNode.next = head;
        buckets.set(index, newNode);
    }

    // Retrieve the value associated with the given key
    public int get(int key) {
        int index = hash(key);
        Node head = buckets.get(index);

        // Search for the key in the linked list
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        
        // Key not found
        return -1;
    }

    // Delete the key-value pair associated with the given key
    public void remove(int key) {
        int index = hash(key);
        Node head = buckets.get(index);

        // Handle deletion from the linked list
        Node prev = null;
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    // If current node is the head of the linked list
                    buckets.set(index, current.next);
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    // Test the Hash Map implementation
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();

        // Inserting key-value pairs
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        map.put(4, 40);
        map.put(5, 50);

        // Retrieving values
        System.out.println("Value for key 3: " + map.get(3)); // Output: 30
        System.out.println("Value for key 6: " + map.get(6)); // Output: -1 (key not found)

        // Deleting key-value pair
        map.remove(4);
        System.out.println("Value for key 4 after deletion: " + map.get(4)); // Output: -1 (key not found)
    }
}
