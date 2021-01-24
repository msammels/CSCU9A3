/**
 * <p>
 *     <b><u>CSCU9A3 - Practical 6</u></b>#
 *     <br />
 *     <b><u>IntTreeNode.java</u></b>
 * </p>
 *
 * @author Michael Sammels
 * @version 29.10.2020
 */

public class IntTreeNode {
    private final int value;
    private IntTreeNode left = null;
    private IntTreeNode right = null;

    /**
     * Default constructor that initialises the node with
     * a value for this node.
     * @param v the value for the node to store
     */
    public IntTreeNode(int v) {
        value = v;
    }

    /**
     * Set the left reference of this node to 'n'
     * @param n a reference to the new left node
     */
    public void setLeft(IntTreeNode n) {
        left = n;
    }

    /**
     * Set the right reference of this node to 'n'
     * @param n a reference to the new right node
     */
    public void setRight(IntTreeNode n) {
        right = n;
    }

    // Get properties of the node
    public int getValue() {
        return value;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public IntTreeNode left() {
        return left;
    }

    public IntTreeNode right() {
        return right;
    }

    public String toString() {
        return String.format("%d", value);
    }
}
