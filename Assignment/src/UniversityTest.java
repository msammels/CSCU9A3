import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * <p>
 *     <b><u>CSCU9A3 Assignment</u></b>
 *     <br />
 *     <b><u>UniversityTest.java</u></b>
 *     </p>
 *     <p>
 *         This UniversityTest class provides different methods of checking the behaviour of the University class and
 *         the objects that it uses. It maintains a reference to a University object called 'stirling' and populates
 *         it via the loadData method.
 *     </p>
 *     <p>
 *         If you run this class via a call to main, main will create a University object and call the
 *         {@link UniversityTest#go()} method which produces some useful output that you can analyse. There are also
 *         some test methods to help you check your code as you go.
 *     </p>
 *     <p>
 *         UniversityTest also contains the following complete test methods that you should implement to confirm that
 *         your tree walk and binary are working as intended. At present this only prints out the results of a tree
 *         walk and search - you need to convert these to use a valid assertion test:
 *     </p>
 *     <p>
 *         {@link UniversityTest#inOrderTest()}
 *         <br />
 *         {@link UniversityTest#binarySearchTest()}
 *     </p>
 *
 * @author 2629330
 * @version 01.11.2020
 */

public class UniversityTest {
    University stirling = new University();

    /**
     * The main launcher method
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        UniversityTest test = new UniversityTest();
        test.go();
    }

    @Before
    public void loadData() {
        stirling.clear();

        Professor[] prof_list = new Professor[]{new Professor("Alek Sib", 159,
                "aleksib@stir.ac.uk"),
                new Professor("Jill Lai", 369, "jl@stir.ac.uk"),
                new Professor("Kevin Jack", 789, "kj@stir.ac.uk"),
                new Professor("Guy F", 654, "gf@stir.ac.uk"),
                new Professor("Loius V", 643, "lv@stir.ac.uk"),
                new Professor("Lett A", 580, "la@stir.ac.uk"),
                new Professor("Stephanie A", 999, "sa@stir.ac.uk")};

        Student[] list = new Student[]{new Student("John J", 147, "jj@stir.ac.uk"),
                new Student("Kate K", 565, "kk@stir.ac.uk"),
                new Student("Loius L", 6542, "ll@stir.ac.uk"),
                new Student("Zhang Z", 805, "zz@stir.ac.uk"),
                new Student("Xing L", 100, "xl@stir.ac.uk"),
                new Student("Alma A", 753, "aa@stir.ac.uk"),
                new Student("Borba B", 888, "bb@stir.ac.uk"),
                new Student("Zeus L", 001, "zl@stir.ac.uk"),
                new Student("Laura Q", 075, "lq@stir.ac.uk"),
                new Student("Pierre A", 130, "pa@stir.ac.uk"),
                new Student("Jess Z", 010, "jz@stir.ac.uk"),
                new Student("Hugh J", 101, "hj@stir.ac.uk"),
                new Student("Paul P", 654, "pp@stir.ac.uk")}; // Include here some MSc Students

        Module a1 = new Module(1235, "Algorithms 1",
                new BinaryTree(new Student[]{list[0], list[1], list[2], list[5]}), prof_list[0]);
        stirling.addModule(a1);

        Module a2 = new Module(6452, "Algorithms 2",
                new BinaryTree(new Student[]{list[3], list[4], list[6]}), prof_list[1]);
        stirling.addModule(a2);

        Module a3 = new Module(8764, "Algorithms 3",
                new BinaryTree(new Student[]{list[6], list[10], list[11], list[10]}), prof_list[2]);
        stirling.addModule(a3);

        Module a4 = new Module(7541, "Data Science 1",
                new BinaryTree(new Student[]{list[5], list[4], list[0], list[11], list[10]}), prof_list[3]);
        stirling.addModule(a4);

        Module a5 = new Module(1000, "Neural Networks 1",
                new BinaryTree(new Student[]{list[0], list[1], list[6], list[7], list[8]}), prof_list[4]);
        stirling.addModule(a5);

        Module a6 = new Module(2005, "Computer Networks 1",
                new BinaryTree(new Student[]{list[2], list[5], list[6], list[9]}), prof_list[5]);
        stirling.addModule(a6);

        Module a7 = new Module(3900, "Graphics",
                new BinaryTree(new Student[]{list[7], list[8], list[9], list[10], list[11]}), prof_list[6]);
        stirling.addModule(a7);

        // Uncomment the following lines when you have built the MScStudent class
        Module a8 = new Module(4511, "Deep Learning",
                new BinaryTree(new Student[]{list[0], list[5], list[11],
                        new MScStudent("Jane G", 561, "jg@stir.ac.uk",
                                "Deep Learning Image Segmentation", prof_list[6]),
                        new MScStudent("Rose T", 300, "rt@stir.ac.uk",
                                "Food Production", prof_list[5])}),
                prof_list[0]);
        stirling.addModule(a8);

        Module a9 = new Module(2314, "Computer Vision",
                new BinaryTree(new Student[]{new MScStudent("Jack I", 200,
                        "ji@stir.ac.uk", "Coronavirus Detection", prof_list[3]),
                        new MScStudent("Mary M", 100,
                                "mm@stir.ac.uk", "Sales Optimization", prof_list[2])}),
                prof_list[2]);
        stirling.addModule(a9);
    }

    /**
     * Print the contents of the ArrayList 'list' to the standard output
     * @param list the list to print
     */
    public void printArrayList(ArrayList<Module> list) {
        for (Module v : list)
            System.out.println(v.toString());
    }

    /**
     * 'go' produces a useful set of output that allows you to see the initial state of the modules ArrayList,
     * the results of doing the tree walk, an attempt at finding an object in the tree and the results of doing
     * a merge sort and a binary search. Initially, only the state of the modules list will be correct. As you
     * add further functionality, you should see the correct output being printed via this method. You do not
     * need to modify it, but you may want to add your own checks to confirm your code is working as intended.
     */
    public void go() {
        loadData();
        System.out.println("-- Module List --");
        stirling.describeModuleList();
        System.out.println();

        System.out.println("-- In Order Walk --\n" + stirling.inWalk(0));

        System.out.println("\n-- Find --");

        Person mf = stirling.find(0, "John J"); // Should be found
        if (mf != null)
            System.out.println("Found: " + mf);
        else
            System.out.println("Could not find John J");

        Person aw = stirling.find(1, "Jack J"); // Should NOT be found
        if (aw != null)
            System.out.println("Found: " + aw);
        else
            System.out.println("Could not find Jack J");

        System.out.println("\n-- Merge Sort (Descending Name) --");
        ArrayList<Module> sorted;

        // Reload the data, otherwise it will still be sorted...
        loadData();
        sorted = stirling.mergeSort(false, "name");
        printArrayList(sorted);

        System.out.println("\n-- Merge Sort (Ascending Code) --");

        // Reload the data, otherwise it will still be sorted...
        loadData();
        sorted = stirling.mergeSort(true, "code");
        printArrayList(sorted);

        System.out.println("\n-- Binary Search --");
        Module bs = stirling.binarySearch("Algorithms 3");  // Should be found
        if (bs != null)
            System.out.println("Found: " + bs);
        else
            System.out.println("Could not find Module Algorithms 3");

        Module bsn = stirling.binarySearch("Biology 1");    // Should NOT be found
        if (bsn != null)
            System.out.println("Found: " + bsn);
        else
            System.out.println("Could not find Module Biology 1");
    }

    /**
     * A test for the in-order walk
     */
    @Test
    public void inOrderTest() {
        int value = (int) (Math.random() * (9));
        // Now conduct an assertion test...
        assertEquals("Incorrect order for in-order walk", "Alma A, John J, Kate K, Loius L, ",
                stirling.inWalk(0));
        System.out.println("\n-- In Order Walk --\n" + stirling.inWalk(0));
    }

    /**
     * A test for the binary search
     */
    @Test
    public void binarySearchTest() {
        // Sort!
        stirling.mergeSort(true, "name");

        // Now conduct an assertion test...
        assertNotNull("Binary Search (found): ", stirling.binarySearch("Algorithms 3"));
        assertNull("Binary Search (not found): ", stirling.binarySearch("Data Science 3"));

        System.out.println("\n-- Binary Search --\n" + stirling.binarySearch("Algorithms 3"));
        System.out.println("\n-- Binary Search --\n" + stirling.binarySearch("Biology 1"));
    }

    /**
     * A test for the find method
     */
    @Test
    public void findTest() {
        assertNull(stirling.find(0, "Murray A"));
        assertNotNull(stirling.find(2, "Hugh J"));
    }

    /**
     * A test for the module enrolment
     */
    @Test
    public void checkModuleEnrolment() {
        Student a = new Student("Julius C", 1598743, "jc@stir.ac.uk");

        assertEquals(a.getNumberModule(), 0);
        assertTrue(a.addModule(1));

        assertEquals(a.getNumberModule(), 1);
        assertTrue(a.addModule(2));

        assertEquals(a.getNumberModule(), 3);
        assertFalse(a.addModule(3));

        assertEquals(a.getNumberModule(), 3);
        assertTrue(a.addModule(2));

        assertEquals(a.getNumberModule(), 5);
    }
}
