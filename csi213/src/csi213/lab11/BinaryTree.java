package csi213.lab11;

public class BinaryTree<T extends Comparable<T>> {
    private Node root; // Add root member to store the root of the tree

    public class Node {
        private T value; // Add member to store the node value
        private Node left; // Add member to store the left child
        private Node right; // Add member to store the right child

        Node(T newOne) {
            value = newOne; // set the value of the node here
            left = null; // initialize left child as null
            right = null; // initialize right child as null
        }
    	// in-order traversal : 
    	// Concatenate: 
    	// 	call toString on the left branch, if there is one.
    	// 	call toString on "this".
    	// 	the literal string ", "
    	// 	call toString on the right branch if there is one.
    	// return that concatenated string
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            if (left != null) {
                sb.append(left.toString());
            }

            sb.append(value.toString());
            sb.append(", ");

            if (right != null) {
                sb.append(right.toString());
            }

            return sb.toString();
        }
    }

    public void add(T item) {
        root = addRecursive(root, item);
    }

    private Node addRecursive(Node current, T item) {
        if (current == null) {
            return new Node(item);
        }

        int cmp = item.compareTo(current.value);

        if (cmp < 0) {
            current.left = addRecursive(current.left, item);
        } else if (cmp > 0) {
            current.right = addRecursive(current.right, item);
        } else {
            // Value already exists in the tree; do nothing
        }

        return current;
    }

    public boolean find(T item) {
        return findRecursive(root, item);
    }

    private boolean findRecursive(Node current, T item) {
        if (current == null) {
            return false;
        }

        int cmp = item.compareTo(current.value);

        if (cmp < 0) {
            return findRecursive(current.left, item);
        } else if (cmp > 0) {
            return findRecursive(current.right, item);
        } else {
            return true;
        }
    }
    // This is correct as is.
    @Override
    public String toString() {
        if (root == null) return "Empty Tree";
        return root.toString();
    }
}
