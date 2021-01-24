import java.util.Arrays;
import java.util.Random;

/**
 * <p>
 *     <b><u>CSCU9A3 - Practical 4</u></b>#
 *     <br />
 *     <b><u>Main.java</u></b>
 * </p>
 *
 * @author Michael Sammels
 * @version 16.10.2020
 */

public class Main {
    /**
     * The main launcher method
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        Module a3 = new Module("CSCU9A3", new int[]{486, 999, 954, 171, 857});

        System.out.println("Original array (before addition): " + Arrays.toString(a3.getList()));
        a3.add_student(854);

        System.out.println("Original array (before subtraction): " + Arrays.toString(a3.getList()));
        a3.remove_student(999);

        System.out.println("\nOriginal array: " + Arrays.toString(a3.getList()));
        a3.sort();  // Calling the sort method
        System.out.println("Sorted array: " + Arrays.toString(a3.getList()));

        System.out.println();
        System.out.println("Find sequential: " + a3.find_sequential(857)); // Calling the find_sequential method

		System.out.println();
        test_sequential_search();
        test_binary_search();
    }

    public static void test_sequential_search() {
        int array_size = 1000;

        // This part creates an array with random int values
        Random rd = new Random(); // Creating Random object
        int[] arr = new int[array_size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(999999999); // Storing random integers in an array
        }

        // Creates a new module using the random array
        Module test = new Module("test", arr);
        Arrays.sort(test.getList());

        // Call the find_sequential method and calculate the time to find the element
        long start = System.nanoTime(); // Return time in nanoseconds

		// Note that we are trying to find the (array_size - 100)th element. In this array you need to run this several
		// times and then calculate the average time
        test.find_sequential(arr[array_size - 100]);
        long end = System.nanoTime();

        System.out.print("Test sequential search: ");
        System.out.println(end - start);
    }

    public static void test_binary_search() {
        int array_size = 1000;

        // This part creates an array with random int values
        Random rd = new Random(); // Creating Random object
        int[] arr = new int[array_size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(999999999); // Storing random integers in an array
        }

        // Creates a new module using the random array
        Module test2 = new Module("test2", arr);
        Arrays.sort(test2.getList());

        // Call the find_sequential method and calculate the time to find the element
        long start = System.nanoTime(); // Return time in nanoseconds

		// Note that we are trying to find the (array_size - 100)th element. In this array you need to run this several
		// times and then calculate the average time
        test2.find_binary(arr[array_size - 100]);
        long end = System.nanoTime();

        System.out.print("Test binary search: ");
        System.out.println(end - start);
    }
}
