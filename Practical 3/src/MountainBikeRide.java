/**
 * <p>
 *     <b><u>CSCU9A3 - Practical 3</u></b>#
 *     <br />
 *     <b><u>MountainBikeRide.java</u></b>
 * </p>
 *
 * @author Michael Sammels
 * @version 08.10.2020
 */

public class MountainBikeRide extends CycleRide {
    public MountainBikeRide(int numberMiles, boolean cycleAlone) {
        super(numberMiles, cycleAlone);
    }

    public double getDifficultyFactor() {
        return 1.5;
    }
}
