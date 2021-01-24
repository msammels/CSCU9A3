/**
 * <p>
 *     <b><u>CSCU9A3 Assignment</u></b>
 *     <br />
 *     <b><u>BinaryTree.java</u></b>
 * </p>
 * <p>
 *     An example of a Binary Tree built using Node objects. Some of the functionality for this class is provided
 *     for you (and may provide clues as to how to implement assignment methods). Your task is to implement the
 *     method bodies for:
 *     <ul>
 *         <li>{@link BinaryTree#inOrder(Node, StringBuffer)}</li>
 *         <li>{@link BinaryTree#find(String, Node)}</li>
 *     </ul>
 * </p>
 *
 * @author 2629330
 * @version 01.11.2020
 */

public class BinaryTree {
    private Node root;	// The root node of the tree
    private int size;	// A count of the nodes in the tree

    public BinaryTree(Person[] stdList) {
        root = null;
        size = 0;

        for (Person s : stdList) {
            addNode(s);
        }
    }

    public BinaryTree() {
        root = null;
        size = 0;
    }

    /**
     * @return the number of nodes in the tree
     */
    public int size() {
        return size;
    }

    /**
     * Empties the tree
     */
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Determines if the tree is empty or not
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty() {
        return (root == null);
    }

    /**
     * Adds a node containing a reference to a person to the tree
     * @param a the content of the node that will be added
     */
    public void addNode(Person a) {
        Node node = new Node(a);

        // If the tree is empty, make our new node the root and leave
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
     * Internal recursive method to add a node to the tree
     * @param c the content to place in the tree
     * @param n the current node to consider, will not be null
     */
    private void addNode(Node c, Node n) {
        /*
        Is our new node content less than our current node content? If it is, we add it to the left side of the
        tree so that when we walk it in with an in-order traversal, the tree content will come out in alphabetic
        order. Conversely add it to the right if it is greater.
         */
        if (c.compareTo(n) < 0) {
            if (n.hasLeft()) {
                addNode(c, n.left());
            } else {
                // The current left node is null so we can attach our new node to the left of the current node
                n.setLeft(c);
            }
        } else {
            if (n.hasRight()) {
                addNode(c, n.right());
            } else {
                // The current right node is null so we can attach our new node to the right of the current node
                n.setRight(c);
            }
        }
    }

    /**
     * Public call to start a recursive in-order traversal using the root of the tree. In-order traversal is often
     * called in-fix traversal
     * @return a reference to a comma-separated String containing the trees contents as determined by an
     * in-order traversal
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
     * Private method used to make a recursive in-order traversal from node 'n'. You should provide the correct
     * recursive implementation for this method
     * @param n the node to perform the inOrder walk from
     * @param sb the string that will be returned in the end of the process
     */
    protected void inOrder(Node n, StringBuffer sb) {
        // We 'visit' the node by adding its contents to our String

        if (n != null) {
            inOrder(n.left(), sb);
            sb.append(n.getPersonName()).append(", ");	// Visit node 'n'
            inOrder(n.right(), sb);
        }
    }

    /**
     * Find the reference for a given person by 'name'
     * @param name the person name to search for
     * @return a reference to the person that was found or null if no person found
     */
    public Person find(String name) {
        return find(name, root);
    }

    /**
     * Find an object within the given node
     * @param name the name to find
     * @param n the node to search
     * @return the found name
     */
    protected Person find(String name, Node n) {
        if (n == null) {
            return null;
        }

        int order = name.compareTo(n.getPersonName());

        if (order == 0) {    			// Found
            return n.getPerson();
        } else if (order < 0) {        	// The name is less than the node, so search left child
            return find(name, n.left());
        } else {                        // Otherwise search the right child
            return find(name, n.right());
        }
    }

    public void printTree() {
        printTree(root, 0);
    }

    /**
     * Internal method used to make a recursive order walk from node 'n'. This method is useful to see the current
     * structure of the tree (turned on its side)
     * @param n		the node to start the reverse order walk from
     * @param depth	the current depth of the node in the tree
     */
    private void printTree(Node n, int depth) {
        if (n.hasRight()) {
            printTree(n.right(), depth + 1);
        }

        // Show depth of current code by indenting to the right
        for (int d = 0; d < depth; d++) {
            System.out.print("  ");
        }

        System.out.println(n.getPersonName());

        if (n.hasLeft()) {
            printTree(n.left(), depth + 1);
        }
    }
}
