public class SegmentTree {
    private int[] segmentTree;
    private int[] originalArray;
    private int n;  // size of the array

    public SegmentTree(int[] arr) {
        n = arr.length;
        originalArray = arr;
        // The segment tree array should be of size 2 * n to accommodate all nodes
        segmentTree = new int[2 * n];
        buildSegmentTree(arr);
    }

    // Build the segment tree from the given array
    private void buildSegmentTree(int[] arr) {
        // Initialize the leaf nodes in the segment tree
        for (int i = 0; i < n; i++) {
            segmentTree[n + i] = arr[i];
        }
        // Build the segment tree by calculating parent nodes
        for (int i = n - 1; i > 0; i--) {
            segmentTree[i] = segmentTree[2 * i] + segmentTree[2 * i + 1];
        }
    }

    // Query the sum in the range [l, r]
    public int rangeSumQuery(int l, int r) {
        // adjust to 0-based index
        l += n;
        r += n;
        int sum = 0;
        while (l <= r) {
            if ((l % 2) == 1) {
                sum += segmentTree[l];
                l++;
            }
            if ((r % 2) == 0) {
                sum += segmentTree[r];
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }

    // Update the value at index idx to newValue
    public void update(int idx, int newValue) {
        // adjust to 0-based index
        idx += n;
        segmentTree[idx] = newValue;
        // Update the segment tree by recalculating parent nodes
        while (idx > 1) {
            idx /= 2;
            segmentTree[idx] = segmentTree[2 * idx] + segmentTree[2 * idx + 1];
        }
    }

    // Print the segment tree (for debugging purposes)
    public void printSegmentTree() {
        System.out.print("Segment Tree: ");
        for (int i = 1; i < segmentTree.length; i++) {
            System.out.print(segmentTree[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree st = new SegmentTree(arr);

        // Example usage: query sum of elements in range [1, 4]
        int l = 1;
        int r = 4;
        System.out.println("Sum of elements in range [" + l + ", " + r + "]: " + st.rangeSumQuery(l, r));

        // Update element at index 2 to 6
        int idx = 2;
        int newValue = 6;
        st.update(idx, newValue);
        System.out.println("Updated segment tree after updating index " + idx + " to " + newValue + ":");
        st.printSegmentTree();
        
        // Query sum of elements in updated range [1, 4]
        System.out.println("Sum of elements in range [" + l + ", " + r + "] after update: " + st.rangeSumQuery(l, r));
    }
}
