/**
 * <p>
 *     <b><u>CSCU9A3 Assignment</u></b>
 *     <br />
 *     <b><u>Module.java</u></b>
 * </p>
 *
 * @author 2629330
 * @version 01.11.2020
 */

public class Module {
    private int code;			// Internal code of the module (e.g. 5246)
    private String name;		// Name of the module
    private BinaryTree btree;	// Binary tree that stores the students enrolled in this module
    private Professor prof;		// Professor teaching this module

    /**
     * Constructor
     * @param c internal code
     * @param n name
     * @param p professor
     */
    public Module(int c, String n, Professor p) {
        this.code = c;
        this.name = n;
        this.btree = new BinaryTree();	// Empty
        this.prof = p;
    }

    /**
     * Constructor
     * @param c internal code
     * @param n name
     * @param bt binary tree with the students enrolled in the module
     * @param p professor
     */
    public Module(int c, String n, BinaryTree bt, Professor p) {
        this.code = c;
        this.name = n;
        this.btree = bt;
        this.prof = p;
    }

    /* Getters and setters! */
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public BinaryTree getBtree() {
        return btree;
    }
    public void setBtree(BinaryTree btree) {
        this.btree = btree;
    }

    public Professor getProf() {
        return prof;
    }
    public void setProf(Professor prof) {
        this.prof = prof;
    }

    // From here, we start methods related to the binary tree that stores the list of students

    /**
     * Add a student to the binary tree
     * @param s the student
     */
    public void addStudent(Student s) {
        btree.addNode(s);
        s.addModule(1);
    }

    /**
     * In-order traversal method
     * @return a string with the names of all students in the tree
     */
    public String inWalk() {
        return btree.inOrderTraversal();
    }

    /**
     * Find a student in the binary tree using the name
     * @param name the name of the student you are searching for
     * @return a reference to the student that was found or null if no student found
     */
    public Person find(String name) {
        return btree.find(name);
    }

    /**
     * Method for printing the tree
     */
    public void describeStudentTree() {
        btree.printTree();
    }

    public String toString() {
        return "Module: " + code + " - " + name + " -- Students: " + btree.inOrderTraversal();
    }
}
