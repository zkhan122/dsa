package BinaryTrees;

import java.io.*;

// Java program for Inserting a node
class BST {

    // Function to create a new BST node
    static Node addNode(int item) {
        Node temp = new Node();
        temp.setKey(item);
        temp.left = temp.right = null;
        return temp;
    }

    // Function to insert a new node with
    // given key in BST
    static Node insert(Node node, int key) {
        // If the tree is empty, return a new node
        if (node == null)
            return addNode(key);

        // Otherwise, recur down the tree
        if (key < node.getKey()) {
            node.setLeft(insert(node.left, key));
        }
        else if (key > node.getKey()) {
            node.setRight(insert(node.right, key));
        }
        // Return the node
        return node;
    }

    // Function to do inorder traversal of BST
    static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(" " + root.getKey());
            inOrder(root.getRight());
        }
    }

    static void preOrder(Node root) {
        if (root != null) {
            System.out.print(" " + root.getKey());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    static void postOrder(Node root) {
        if (root != null) {
            preOrder(root.getLeft());
            preOrder(root.getRight());
            System.out.print(" " + root.getKey());
        }
    }

    // Print nodes at a given level
    static void printGivenLevel(Node root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(" " + root.getKey());
        else if (level > 1) {

            // Recursive Call
            printGivenLevel(root.getLeft(), level - 1);
            printGivenLevel(root.getRight(), level - 1);
        }
    }

    static void levelOrder(Node root) {
        int height = height(root);
        for (int i = 1; i <= height; i++) {
            printGivenLevel(root, i);
            System.out.println();
        }
    }

    static Node minValueNode(Node node)
    {
        Node current = node;

        // Loop down to find the leftmost leaf
        while (current != null && current.left != null)
            current = current.left;

        return current;
    }

    static Node deleteNode(Node root, int keyToDelete) {
        // base case
        if (root == null) {
            return root;
        }
        if (keyToDelete < root.getKey()) {
            root.setLeft(deleteNode(root.getLeft(), keyToDelete));
        }
        else if (keyToDelete > root.getKey()) {
            root.setRight(deleteNode(root.getRight(), keyToDelete));
        }
        // if root is to be deleted
        else {
            if (root.getLeft() == null) {
                return root.getRight();
            }
            else if (root.getRight() == null) {
                return root.getLeft();
            }
            // Get smallest in right subtree (Node with 2 children)
            Node temp = minValueNode(root.getRight());

            root.key = temp.key;

            root.setRight(deleteNode(root.getRight(), temp.getKey()));
        }
        return root;
     }

     static int height(Node node) {
        if (node == null) {
            return 0;
        }
        else {
            int leftDepth = height(node.getLeft());
            int rightDepth = height(node.getRight());

            // if unbalanced
            if (leftDepth > rightDepth) {
                return leftDepth + 1;
            } else {
                return rightDepth + 1;
            }
        }
     }

    // Driver Code
    public static void main(String[] args) {
		/*
			  50
			/	 \
		   30	 70
		   / \   / \
		   20 40 60 80
	*/
        Node root = null;

        // inserting value 50
        root = insert(root, 50);
        insert(root, 30);
        insert(root, 20);
        insert(root, 40);
        insert(root, 70);
        insert(root, 60);
        insert(root, 80);
        // print the BST
        System.out.println("In order traversal: ");
        inOrder(root);
        System.out.println();
        System.out.println("Pre order traversal: ");
        preOrder(root);
        System.out.println();
        System.out.println("Post order traversal: ");
        postOrder(root);

        System.out.println();
        System.out.println("\n(DELETE) After deletion of 60");

        root = deleteNode(root, 60);
        inOrder(root);

        System.out.println("\n Level Order Traversal: ");
        levelOrder(root);

        System.out.println("Height of tree: " + height(root));

    }
}
