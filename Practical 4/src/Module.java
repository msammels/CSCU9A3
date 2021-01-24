import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>
 *     <b><u>CSCU9A3 - Practical 4</u></b>#
 *     <br />
 *     <b><u>Module.java</u></b>
 * </p>
 *
 * @author Michael Sammels
 * @version 16.10.2020
 */

public class Module {
    private final Logger logger;
    private int[] list;

    public Module(String module_name, int[] list) {
        this.list = list;

        logger = Logger.getLogger("Logging module " + module_name);
        logger.setLevel(Level.SEVERE);  // This will only log/print SEVERE type messages
    }

    public int[] getList() {
        return list;
    }

    public void add_student(int s) {
        logger.log(Level.INFO, "Adding student " + s);
        if (find_sequential(s) == -1) { // Check if the list contains student s
            logger.log(Level.INFO, "Current student list " + Arrays.toString(list));

            int[] new_list = new int[list.length + 1];
            System.arraycopy(list, 0, new_list, 0, list.length);

            new_list[list.length] = s;
            list = new_list;

            logger.log(Level.INFO, "New current student list " + Arrays.toString(list));
        } else {
            logger.log(Level.WARNING, "You can not add the same student twice");
        }
    }

    public void remove_student(int s) {
        logger.log(Level.INFO, "Removing student " + s);
        logger.log(Level.INFO, "Current student list " + Arrays.toString(list));

        try {
            int[] new_list = new int[list.length - 1];
            for (int i = 0, c = 0; i < list.length; i++) {
                if (list[i] != s) {
                    new_list[c++] = list[i];
                }
            }
            list = new_list;
            logger.log(Level.INFO, "New current student list " + Arrays.toString(list));
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Could not remove student. Error: " + e);
        }
    }

    public void sort() {
        // This is the bubble sort, the simplest sorting algorithm
        for (int i = 0; i < (list.length - 1); i++) {
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    public int find_sequential(int s) {
        int index = -1;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == s) {
                index = i;
            }
        }
        return index;
    }

    public void find_binary(int element) {
        int lowIndex = 0;
        int highIndex = list.length - 1;

        // Holds the element position in array for given element. Initial negative integer set to be returned if no
		// match was found in array

        // If lowIndex less than highIndex, there's still elements in the array
        while (lowIndex <= highIndex) {
            int midIndex = (lowIndex + highIndex) / 2;
            if (element == list[midIndex]) {
                break;
            } else if (element < list[midIndex]) {
                highIndex = midIndex - 1;
            } else if (element > list[midIndex]) {
                lowIndex = midIndex + 1;
            }
        }
    }
}
