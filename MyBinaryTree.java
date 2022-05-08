public class MyBinaryTree {

    public static void main(String[] args) {

        MyBinaryTree tree = new MyBinaryTree();

        for (int i = 0; i < args.length; i++) {
            try {
                tree.add(Integer.parseInt(args[i]));
            } catch (Exception e) {
                // attemping to remove non integer values + e.getMessage()
            }
        }
        tree.inOrder(); // post sorted list
    }

    BTNode root;

    void add(int newNum) { // add a node to tree, taken partially from textbook 12.3

        BTNode newNode = new BTNode();
        newNode.key = newNum;

        BTNode x = root;
        BTNode y = null;

        while (x != null) {
            y = x;

            if (newNum <= x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        if (y == null) {
            root = newNode;
        } else if (newNum <= y.key) {
            y.left = newNode;
            newNode.parent = y;
        } else {
            y.right = newNode;
            newNode.parent = y;
        }
    } // end add

    BTNode transplant(BTNode node, int delNum) {

        if (node == null) { // check if root is empty
            return node;
        }

        if (delNum < node.key) {    // if the number is less than the nodes key
            node.left = transplant(node.left, delNum);  // going to left subtree
        } else if (delNum > node.key) { // if value is greater than key
            node.right = transplant(node.right, delNum);    // going to right subtree
        } else {
            if (node.left == null) {
                if (node.right != null) {
                    node.right.parent = node.parent;
                }
                return node.right;
            } else if (node.right == null) {
                node.left.parent = node.parent;
                return node.left;
            }
            node.right = transplant(node.right, node.key);
        }
        return node;
    }

    boolean delete(int delNum) {

        boolean deleted = false;

        while (contains(delNum)) {  // trying while loop to delete duplicates
            root = transplant(root, delNum);
            deleted = true;
        }
        return deleted;
    }


    boolean contains(int key) { // basic iterative search algorithm
        BTNode node = root; // pointer node

        while (node != null) {
            if (node.key == key) {
                return true;
            } else if (node.key > key) {    // if nodes key is greater than search key, move to the left
                node = node.left;
            } else {
                node = node.right;  // else go right
            }
        }
        return false;   // if not found or null pointer, return false
    }

    void inOrder(BTNode node) { // left, root, right
        if (node == null) {
            return;
        }
        inOrder(node.left); // left
        System.out.print(node.key + " ");   // root
        inOrder(node.right);    // right
    }

    String inOrder() {
        inOrder(root);
        return "";
    }

    void preOrder(BTNode node) {    // root, left, right
        if (node == null) {
            return;
        }
        System.out.print(node.key + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    String preOrder() {
        preOrder(root);
        return "";
    }

    void postOrder(BTNode node) {   // left, right, root
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.key + " ");
    }

    String postOrder() {
        postOrder(root);
        return "";
    }

    class BTNode {
        int key;
        BTNode parent;
        BTNode left;
        BTNode right;
    }
}
