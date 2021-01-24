/**
 * <p>
 *     <b><u>CSCU9A3 - Practical 1</u></b>
 *     <br />
 *     <b><u>Main.java</u></b>
 * </p>
 *
 * @author Michael Sammels
 * @version 27.09.2020
 */

public class Main {
    /**
     * <p>The cycle calculator object</p>
     */
    private static final CycleCalculator cycleCalculator = new CycleCalculator();

    /**
     * The main launcher method
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        // Testing competency
        System.out.println("Beginner competency level is correct? " + (1.5 ==
                cycleCalculator.getDuration(15, "Beginner", 0, true,
                        15, 0, false)));
        System.out.println("Intermediate competency level is correct? " + (2.0 ==
                cycleCalculator.getDuration(30, "Intermediate", 0,
                        true, 15, 0, false)));
        System.out.println("Advanced competency level is correct? " + (1.0 ==
                cycleCalculator.getDuration(20, "Advanced", 0,
                        true, 15, 0, false)));

        // Testing buddy
        System.out.println("Test cycling with a buddy is correct? " + (2.0 ==
                cycleCalculator.getDuration(24, "Beginner", 0,
                        false, 15, 0, false)));
        System.out.println("Test cycling alone is correct? " + (2.4 ==
                cycleCalculator.getDuration(24, "Beginner", 0,
                        true, 15, 0, false)));

        // Testing years experience
        System.out.println("Test years experience is correct? " + (1.0 ==
                cycleCalculator.getDuration(11, "Beginner", 5,
                        true, 15, 0, false)));

        // Testing temperature
        System.out.println("Test temperature more than 10 is correct? " + (1.8 ==
                cycleCalculator.getDuration(18, "Beginner", 0,
                        true, 15, 0, false)));
        System.out.println("Test temperature less than 10 is correct? " + (2 ==
                cycleCalculator.getDuration(18, "Beginner", 0,
                        true, 0, 0, false)));
        System.out.println("Test temperature more than 20 is correct? " + (2.0 ==
                cycleCalculator.getDuration(18, "Beginner", 0,
                        true, 30, 0, false)));
        System.out.println("Test temperature less than 20 is correct? " + (1.0 ==
                cycleCalculator.getDuration(10, "Beginner", 0,
                        true, 15, 0, false)));

        // Testing wind
        System.out.println("Test wind speed at 10mph is correct? " + (1.0 ==
                cycleCalculator.getDuration(10, "Beginner", 0,
                        true, 15, 10, false)));
        System.out.println("Test wind speed at 20mph is correct? " + (1.0 ==
                cycleCalculator.getDuration(9, "Beginner", 0,
                        true, 15, 20, false)));
        System.out.println("Test wind speed at 70mph is correct? " + (1.0 ==
                cycleCalculator.getDuration(6, "Beginner", 0,
                        true, 15, 70, false)));

        // Testing rain
        System.out.println("Test raining is correct? " + (2.0 ==
                cycleCalculator.getDuration(16, "Beginner", 0,
                        true, 15, 0, true)));
        System.out.println("Test not raining is correct? " + (1.0 ==
                cycleCalculator.getDuration(10, "Beginner", 0,
                        true, 15, 0, false)));

        // Testing total duration
        System.out.println("Test adding up total durations is correct? " + (23.4 ==
                cycleCalculator.getTotalDuration(new double[]{0.5, 1.2, 3.4, 5.6, 2.32, 1.4, 8.98})));
        System.out.println("Test adding up total durations is correct? " + (28.13 ==
                cycleCalculator.getTotalDuration(new double[]{2, 5.65, 4.8, 7.5, 6.98, 1.2})));

        System.out.println("Test Formatted Duration is correct? " +
                "1 hours, 59 minutes".equals(cycleCalculator.getFormattedDuration(1.99)));
    }
}
