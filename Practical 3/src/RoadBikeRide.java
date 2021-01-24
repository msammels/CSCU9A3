/**
 * <p>
 *     <b><u>CSCU9A3 - Practical 3</u></b>#
 *     <br />
 *     <b><u>RoadBikeRide.java</u></b>
 * </p>
 *
 * @author Michael Sammels
 * @version 08.10.2020
 */

public class RoadBikeRide extends CycleRide {
    public RoadBikeRide(int numberMiles, boolean cycleAlone) {
        super(numberMiles, cycleAlone);
    }

    public double getDifficultyFactor() {
        return 0.5;
    }
}
