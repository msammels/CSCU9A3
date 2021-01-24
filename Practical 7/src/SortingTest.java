import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * <p>
 *     <b><u>CSCU9A3 - Practical 7</u></b>
 *     <br />
 *     <b><u>SortingTest.java</u></b>
 * </p>
 *
 * @author Michael Sammels
 * @version 11.11.2020
 */

public class SortingTest {
    @Test
    public void selectionSortTest() {
        int[] data = {5, 3, 7, 1, 9, 4, 2};
        int[] expected = {1, 2, 3, 4, 5, 7, 9};

        Sorting s = new Sorting();

        s.selectionSort(data);

        for (int value : data) System.out.print(value + ",");

        System.out.println();

        assertArrayEquals(expected, data);
    }

    public long sortForSize(int n) {
        // Create an array to hold a data set of size 'n'
        int[] data = new int[n];

        // Fill up our array with random numbers
        for (int i = 0; i < n; i++) data[i] = (int) (Math.random() * 100000.0f);

        Sorting s = new Sorting();

        // Now sort them and time how long it takes
        return s.selectionSort(data);
    }

    // Uncomment the @Test line when you are ready to run this test
    @Test
    public void timeSelectionSort() {
        long time;
        int size = 100;

        time = sortForSize(size);

        // Print out the data set size against the time taken in milli seconds
        System.out.printf("%d\t%.3f%n", size, time / 1000000.0f);
    }
}
