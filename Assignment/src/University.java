import java.util.ArrayList;

/**
 * <p>
 *     <b><u>CSCU9A3 Assignment</u></b>
 *     <br />
 *     <b><u>University.java</u></b>
 * </p>
 * <p>
 *     University maintains an ArrayList called Modules that stores the list of modules offered by the university.
 *     Your task is to correctly implement method bodies for:
 *     <ul>
 *         <li>{@link University#binarySearch(ArrayList, String)}</li>
 *         <li>{@link University#mergeSort(ArrayList, boolean, String)}</li>
 *     </ul>
 *     The above methods are called via public methods of the same name which supply the local modules object as a
 *     parameter. You can observe calls to these public methods in the go methods of UniversityTest.java
 * </p>
 *
 * @author 2629330
 * @version 01.11.2020
 */

public class University {
    private ArrayList<Module> modules;

    public University() {
        modules = new ArrayList<Module>();
    }

    public void clear() {
        for (Module v : modules) {
            v.getBtree().clear();
        }
        modules.clear();
    }

    public void addModule(Module v) {
        modules.add(v);
    }

    public void describeModuleList() {
        for (Module v : modules) {
            System.out.println(v.toString());
            v.describeStudentTree();
        }
    }

    /**
     * This method calls the in-order traversal method for a specific module
     * @param val the index of the module that you want to call the inWalk method for
     * @return a string with the names of all students in the tree
     */
    public String inWalk(int val) {
        return modules.get(val).inWalk();
    }

    /**
     * This method calls the find method for a specific module
     * @param val  the index of the module that yuo want to call the inWalk method for
     * @param name the name of the student
     * @return a return reference to the student that was found, or null if no student found
     */
    public Person find(int val, String name) {
        return modules.get(val).find(name);
    }

    /**
     * This method should use a binary search approach to find for the Module (based on the name) in the ArrayList
     * 'modules' - <b>you should not modify this code</b>
     * @param name module name to be found
     * @return the module that was found or null if no module found
     */
    public Module binarySearch(String name) {
        return binarySearch(modules, name);
    }

    /**
     * This method should use a binary search approach to find for the Module (based on its name) in the ArrayList
     * 'modules'
     * @param list an ArrayList of Modules objects to search
     * @param name Module name to be found
     * @return the module that was found, or null if no module found
     */
    protected Module binarySearch(ArrayList<Module> list, String name) {
        // Use the binary search algorithm to search the 'modules' and then return it. Initially this method just
        // returns null - you need to fix this
        int low = 0;
        int high = list.size() - 1;

        while (high >= low) {
            int middle = (high + low) / 2;
            int cmp = list.get(middle).getName().compareTo(name);
            if (cmp == 0) {
                return list.get(middle);
            } else if (cmp < 0) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return null;
    }

    /**
     * This method should use a merge sort approach to rearrange the references in the ArrayList 'modules' such that
     * they are in order according to the attr (attribute) parameter
     * <ul>
     *     <li>If asc is true, this should be ascending order</li>
     *     <li>If asc is false, this should be descending order</li>
     * </ul>
     * <b>You should not modify this code</b>
     * @param asc  true if the list should be ascending order, false for descending
     * @param attr attribute (name or code) that will be used during the sorting
     * @return the ArrayList 'modules' that have been sorted using merge sort
     */
    public ArrayList<Module> mergeSort(boolean asc, String attr) {
        return mergeSort(modules, asc, attr);
    }

    /**
     * This method should use a merge sort approach to rearrange the references in ArrayList 'modules' such that
     * they are in order according to the attr (attribute) parameter.
     * <ul>
     *     <li>If asc is true, this should be ascending order</li>
     *     <li>If asc is false, this should be descending order</li>
     * </ul>
     * @param list      the ArrayList to be sorted
     * @param ascending true if list should be ascending order, false for descending
     * @param attr      attribute (name or code) that will be used during the sorting
     * @return the ArrayList 'modules' that have been sorted using merge sort
     */
    protected ArrayList<Module> mergeSort(ArrayList<Module> list, boolean ascending, String attr) {
        // Use the merge sort algorithm to sort 'modules' and then return it. Initially this method just returns
        // an empty list - you need to fix this
        if (list.size() <= 1) {
            return list;
        } else {
            // Otherwise, split in half, sort them, and merge results
            ArrayList<Module> left = new ArrayList<>();
            ArrayList<Module> right = new ArrayList<>();

            for (int i = 0; i < list.size(); i++) {
                if (i < list.size() / 2) {
                    left.add(list.get(i));
                } else {
                    right.add(list.get(i));
                }
            }
            left = mergeSort(left, ascending, attr);
            right = mergeSort(right, ascending, attr);

            ArrayList<Module> sorted = new ArrayList<Module>();
            while (!(left.isEmpty() || right.isEmpty())) {		// While left and right have elements
                if (attr.equals("code")) {
                    if (ascending) {
                        if (left.get(0).getCode() < right.get(0).getCode()) {
                            sorted.add(left.remove(0));
                        } else {
                            sorted.add(right.remove(0));
                        }
                    } else {
                        if (left.get(0).getCode() > right.get(0).getCode()) {
                            sorted.add(left.remove(0));
                        } else {
                            sorted.add(right.remove(0));
                        }
                    }
                } else {
                    if (ascending) {
                        if (left.get(0).getName().compareTo(right.get(0).getName()) < 0) {
                            sorted.add(left.remove(0));
                        } else {
                            sorted.add(right.remove(0));
                        }
                    } else {
                        if (left.get(0).getName().compareTo(right.get(0).getName()) > 0) {
                            sorted.add(left.remove(0));
                        } else {
                            sorted.add(right.remove(0));
                        }
                    }
                }
            }

            while (!left.isEmpty()) {
                sorted.add(left.remove(0));
            }

            while (!right.isEmpty()) {
                sorted.add(right.remove(0));
            }

            return sorted;
        }
    }
}
