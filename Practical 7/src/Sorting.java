/**
 * <p>
 * <b><u>CSCU9A3 - Practical 7</u></b>
 * <br />
 * <b><u>Sorting.java</u></b>
 * </p>
 *
 * @author Michael Sammels
 * @version 11.11.2020
 */

public class Sorting {
    public long selectionSort(int[] data) {
        // Note the time at the start
        long startTime = System.nanoTime();

        // Your implementation code should go here...
        for (int i = 0; i < data.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < data.length; j++) {
                if (data[min] > data[j]) {
                    min = j;
                }
            }

            if (min != i) {
                int temp = data[i];
                data[i] = data[min];
                data[min] = temp;

            }
        }

        // Return how much time has elapsed to do this task
        return System.nanoTime() - startTime;
    }
}
