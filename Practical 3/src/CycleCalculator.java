/**
 * <p>
 *     <b><u>CSCU9A3 - Practical 3</u></b>#
 *     <br />
 *     <b><u>CycleCalculator.java</u></b>
 * </p>
 * <p>
 *     CycleCalculator class which uses Colin's top secret rules to calculate the estimated duration of a cycle given
 *     certain information about the cyclist, the route and the weather.
 * </p>
 *
 * @author Michael Sammels
 * @version 08.10.2020
 */

public class CycleCalculator {
    // The nice new method that we're refactoring. It is already receiving objects of two classes
    // (CycleRide and Cyclist) instead of parameters. Refactor more!
    public double getDuration(CycleRide cycleRide, Cyclist cyclist, Weather weather) {
        double speed = 0;

        // Competency
        if (cyclist.isBeginner()) {
            speed = 10;
        } else if (cyclist.isIntermediate()) {
            speed = 15;
        } else if (cyclist.isAdvanced()) {
            speed = 20;
        }

        // Cycling buddy
        if (!cycleRide.isCycleAlone()) {
            speed = speed * 1.2;
        }

        // Experience
        speed = speed + (cyclist.getNumYearsExperience() * 0.2);

        // Weather:

        // Temperature
        if (weather.getTemp() <= 10) {
            speed = speed - ((10 - weather.temp) * 0.1);
        } else if (weather.getTemp() >= 20) {
            speed = speed - ((weather.temp - 20) * 0.1);
        }

        // Wind
        if (weather.getWindSpeed() >= 15) {
            speed = speed - (double) (weather.windSpeed / 15);
        }

        // Rain
        if (weather.getIsRaining()) {
            speed = speed - 2;
        }

        return cycleRide.getNumberMiles() / speed * (cycleRide.getDifficultyFactor());
    }
}
