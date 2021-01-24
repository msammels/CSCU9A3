/**
 * <p>
 *     <b><u>CSCU9A3 - Practical 6</u></b>#
 *     <br />
 *     <b><u>IntegerTree.java</u></b>
 * </p>
 * <p>
 *     An example of a Binary Tree built from IntTreeNode nodes
 * </p>
 *
 * @author Michael Sammels
 * @version 29.10.2020
 */

public class IntegerTree {
    private IntTreeNode root;    // The root node of the tree
    private int size = 0;        // A count of the nodes in the tree

    /**
     * Adds an IntTreeNode to the tree that will provide a Binary Tree.
     * @param val the integer value to be added
     */
    public void addNode(int val) {
        IntTreeNode node = new IntTreeNode(val);

        // If tree is empty, make our new node the root and leave
        if (root == null) {
            root = node;
            size = 1;
        } else {
            // Start the recursive calls to add the descendants of node 'p'
            addNode(node, root);
            size = size + 1;
        }
    }

    /**
     * Internal recursive method to add a node
     * @param c the node to place in the tree
     * @param node the current node to consider, will not be null
     */
    private void addNode(IntTreeNode c, IntTreeNode node) {
        // Is our new node value less than our current node value? If it is, we add it to the left side of the tree
        // so that when we walk it with an in-order traversal, the tree content will come out in alphabetic order.
        // Conversely add it to the right if it is greater.
        if (c.getValue() < node.getValue()) {
            if (node.hasLeft()) {
                addNode(c, node.left());
            } else {
                // Attach it to the left of the current node
                node.setLeft(c);
            }
        } else {
            if (node.hasRight())
                addNode(c, node.right());
            else {
                // Attach it to the right of the current node
                node.setRight(c);
            }
        }
    }

    /**
     * Public call to start the recursive pre-order traversal
     * using the root of the tree.
     * @return a reference to a comma separated String containing the trees contents as determined by a
     * preOrder Traversal.
     */
    public String preOrderTraversal() {
        StringBuffer buff = new StringBuffer();

        if (root == null) {
            return "Empty Tree!";
        } else {
            preOrder(root, buff);
        }

        return buff.toString();
    }

    /**
     * Private method used to make a recursive call from a particular node
     * @param n the node to perform a pre-order traversal from.
     * @param sb the StringBuffer to store the results of walking the tree
     */
    private void preOrder(IntTreeNode n, StringBuffer sb) {
        sb.append(n).append(","); // 'Visit' n

        // Visit left
        if (n.hasLeft()) {
            preOrder(n.left(), sb);
        }

        // Visit right
        if (n.hasRight()) {
            inOrder(n.right(), sb);
        }
    }

    /**
     * Public call to start a recursive in-order traversal using
     * the root of the tree.
     * @return a reference to a comma separated String containing the trees contents as determined by an
     * in-order traversal.
     */
    public String inOrderTraversal() {
        StringBuffer buff = new StringBuffer();

        if (root == null) {
            return "Empty Tree!";
        } else {
            inOrder(root, buff);
        }

        return buff.toString();
    }

    /**
     * Private method used to make a recursive in-order traversal from node 'n'
     * @param n the node to perform the inOrder walk from
     * @param sb the StringBuffer to store the results of walking the tree
     */
    private void inOrder(IntTreeNode n, StringBuffer sb) {
        // Visit left
        if (n.hasLeft()) {
            inOrder(n.left(), sb);
        }
        sb.append(n).append(","); // Visit 'n'

        // Visit right
        if (n.hasRight()) {
            inOrder(n.right(), sb);
        }
    }

    /**
     * Public call to start the recursive post-order traversal using
     * the root of the tree.
     * @return a reference to a comma separated String containing the trees contents as determined by a
     * post-order traversal.
     */
    public String postOrderTraversal() {
        StringBuffer buff = new StringBuffer();

        if (root == null) {
            return "Empty Tree!";
        } else {
            postOrder(root, buff);
        }

        return buff.toString();
    }

    /**
     * Private method used to make a recursive post-order traversal for node 'n'
     * @param n the node to perform the postOrder walk from
     * @param sb the StringBuffer to store the results of walking the tree
     */
    private void postOrder(IntTreeNode n, StringBuffer sb) {
        // Visit left
        if (n.hasLeft()) {
            postOrder(n.left(), sb);
        }

        // Visit right
        if (n.hasRight()) {
            postOrder(n.right(), sb);
        }
        sb.append(n).append(","); // 'Visit' n
    }

    public void printTree() {
        printTree(root, 0);
    }

    /**
     * Internal method used to make a recursive reverse order walk from node 'n'
     * @param n the node to start the reverse order walk from
     * @param depth the current depth of the node in the tree
     */
    private void printTree(IntTreeNode n, int depth) {
        if (n.hasRight()) {
            printTree(n.right(), depth + 1);
        }

        // Show depth of current code by indenting to the right
        for (int d = 0; d < depth; d++) {
            System.out.print("  ");
        }

        System.out.println(n);

        if (n.hasLeft()) {
            printTree(n.left(), depth + 1);
        }
    }
}
