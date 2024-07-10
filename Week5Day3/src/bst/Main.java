package bst;

// Node class representing each node in the BST
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

// Binary Search Tree (BST) class
class BST {
    TreeNode root;

    public BST() {
        this.root = null;
    }

    // Method to perform in-order traversal recursively
    public void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.val + " ");
            inOrderTraversal(node.right);
        }
    }

    // Utility method to perform in-order traversal starting from the root
    public void inOrder() {
        inOrderTraversal(root);
        System.out.println(); // To print a new line after traversal
    }
}

// Main class to demonstrate in-order traversal of BST
public class Main {
    public static void main(String[] args) {
        BST bst = new BST();

        // Constructing a sample BST
        bst.root = new TreeNode(5);
        bst.root.left = new TreeNode(3);
        bst.root.right = new TreeNode(8);
        bst.root.left.left = new TreeNode(2);
        bst.root.left.right = new TreeNode(4);
        bst.root.right.left = new TreeNode(6);
        bst.root.right.right = new TreeNode(9);

        // Performing in-order traversal
        System.out.println("In-order traversal of the BST:");
        bst.inOrder();
    }
}
