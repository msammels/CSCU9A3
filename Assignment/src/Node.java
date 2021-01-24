/**
 * <p>
 *     <b><u>CSCU9A3 Assignment</u></b>
 *     <br />
 *     <b><u>Node.java</u></b>
 * </p>
 * <p>
 *     A node in the Binary Tree. It contains a reference to a Person object associated with the node and references
 *     to the left and right Node objects that are below the node.
 *     <br />
 *     <b>ATTENTION:</b> you do <b>NOT</b> need to modify this code at all.
 * </p>
 *
 * @author 2629330
 * @version 01.11.2020
 */

public class Node {
    private Person person = null;	// The Person stored at this node
    private Node left = null;		// The left node of this node
    private Node right = null;		// The right node of this node

    /**
     * Default constructor that initialises the node with a Page associated with this node
     * @param a the content of the node
     */
    public Node(Person a) {
        person = a;
    }

    /**
     * Set the left references of this node to 'n'
     * @param n a reference to the new left node
     */
    public void setLeft(Node n) {
        left = n;
    }

    /**
     * Set the right reference of this node to 'n'
     * @param n a reference to the new right now
     */
    public void setRight(Node n) {
        right = n;
    }

    // Get properties of the node
    public Person getPerson() { return person; }
    public String getPersonName() { return person.getFullName(); }
    public boolean hasLeft() { return left != null; }
    public boolean hasRight() { return right != null; }
    public Node left() { return left; }
    public Node right() { return right; }

    public int compareTo(Node pn) { return getPersonName().compareTo(pn.getPersonName()); }
    public String toString() { return getPersonName(); }
}
