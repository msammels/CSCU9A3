/**
 * <p>
 *     <b><u>CSCU9A3 - Practical 1</u></b>
 *     <br />
 *     <b><u>CycleCalculator.java</u></b>
 * </p>
 * <p>
 *     CycleCalculator class which uses Colin's top secret rules to calculate the estimated duration of a cycle given
 *     certain information about the cyclist, the route and the weather.
 * </p>
 *
 * @author Michael Sammels
 * @version 27.09.2020
 */

public class CycleCalculator {

    /**
     * Get the duration of the cycle ride
     * @param numMiles the number of miles
     * @param competency the competency
     * @param numYearsExperience the number of years of experience
     * @param cyclingAlone is the rider cycling alone?
     * @param temp the outside temperature
     * @param windSpeed the current wind speed
     * @param isRaining is it raining or not?
     * @return the duration
     */
    public double getDuration(int numMiles, String competency, int numYearsExperience, boolean cyclingAlone,
                              int temp, int windSpeed, boolean isRaining) {
        double speed = 0;

        int BEGINNER = 10;
        if (competency.startsWith("Begin")) speed = BEGINNER;
        int INTER = 15;
        if (competency.startsWith("Int")) speed = INTER;
        int ADVANCED = 20;
        if (competency.startsWith("Adv")) speed = ADVANCED;

        if (!cyclingAlone) speed = speed * 1.2;

        speed = speed + (numYearsExperience * 0.2f);

        int LOW_TEMP = 10;
        if (temp < LOW_TEMP) speed = speed - ((LOW_TEMP - temp) * 0.1f);
        int HI_TEMP = 20;
        if (temp > HI_TEMP) speed = speed - ((temp - HI_TEMP) * 0.1f);

        int windSets = windSpeed / 15;

        speed = speed - (windSets);

        if (isRaining) speed = speed - 2;

        return numMiles / speed;
    }

    /**
     * Get the total duration
     * @param durations the array of durations
     * @return the total duration
     */
    public double getTotalDuration(double[] durations) {
        double total = 0;

        for (double d : durations)
            total += d;

        return total;
    }

    /**
     * Get the formatted duration
     * @param duration a combination of hours and minutes
     * @return the human readable duration
     */
    public String getFormattedDuration(double duration) {
        double hours = Math.floor(duration);
        double minutes = (duration % 1) * 60;

        return String.format("%.0f hours, %.0f minutes", hours, minutes);
    }
}
