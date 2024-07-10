import java.util.Arrays;

public class MinHeap {
    private int capacity;
    private int size;
    private int[] heap;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // Helper methods to get parent index, left child index, and right child index
    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }

    // Swap two nodes in the heap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Insert a new key into the heap
    public void insert(int key) {
        if (size >= capacity) {
            System.out.println("Heap overflow");
            return;
        }

        // Insert the new key at the end
        int index = size;
        heap[index] = key;
        size++;

        // Maintain heap property: bubble up the new element if necessary
        while (index != 0 && heap[parent(index)] > heap[index]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    // Heapify function to restore heap property
    private void heapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;

        // Find the smallest element among root, left child, and right child
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        // Swap root with the smallest element if needed, and recursively heapify the affected sub-tree
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    // Remove and return the minimum element from the heap
    public int extractMin() {
        if (size <= 0) {
            throw new IllegalStateException("Heap underflow");
        }
        if (size == 1) {
            size--;
            return heap[0];
        }

        // Store the minimum value, and replace it with the last element in the heap
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;

        // Restore heap property
        heapify(0);

        return root;
    }

    // Print the heap
    public void printHeap() {
        System.out.print("Heap: ");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        
        // Inserting elements into the heap
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(7);
        minHeap.insert(8);
        minHeap.insert(4);
        minHeap.insert(10);
        minHeap.insert(16);
        
        // Print the initial heap
        minHeap.printHeap();
        
        // Extracting minimum elements from the heap
        System.out.println("Extracted min: " + minHeap.extractMin());
        System.out.println("Extracted min: " + minHeap.extractMin());
        
        // Print the heap after extraction
        minHeap.printHeap();
    }
}
