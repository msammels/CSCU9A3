import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 *     <b><u>CSCU9A3 - Practical 3</u></b>
 *     <br />
 *     <b><u>CycleCalculatorAdvancedTest.java</u></b>
 * </p>
 *
 * @author Michael Sammels
 * @version 08.10.2020
 */

public class CycleCalculatorAdvancedTest {
    private static final double ACCURACY = 0.001;

    private CycleCalculator cycleCalculator;

    @Before
    public void setup() {
        cycleCalculator = new CycleCalculator();
    }

    @Test
    public void testCycleRide() {
        CycleRide cycle1 = new CycleRide(10, true);
        Cyclist cyclist1 = new Cyclist("Beginner", 0);
        Weather weather1 = new Weather(15, 0, false);
        assertEquals("Beginner competency level failed:", 1.0,
                cycleCalculator.getDuration(cycle1, cyclist1, weather1), ACCURACY);
    }

    @Test
    // Create a test here for the MountainBikeRide
    public void testMountainBikeRide() {
        CycleRide cycle2 = new MountainBikeRide(15, true);
        Cyclist cyclist2 = new Cyclist("Intermediate", 0);
        Weather weather2 = new Weather(15, 0, false);
        assertEquals("Intermediate competency level failed:", 1.5,
                cycleCalculator.getDuration(cycle2, cyclist2, weather2), ACCURACY);
    }

    @Test
    // Create a test here for the RoadBikeRide
    public void testRoadBikeRide() {
        CycleRide cycle3 = new RoadBikeRide(20, true);
        Cyclist cyclist3 = new Cyclist("Advanced", 0);
        Weather weather3 = new Weather(15, 0, false);
        assertEquals("Advanced competency level failed:", 0.5,
                cycleCalculator.getDuration(cycle3, cyclist3, weather3), ACCURACY);
    }
}
