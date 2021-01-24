/**
 * <p>
 *     <b><u>CSCU9A3 - Practical 3</u></b>#
 *     <br />
 *     <b><u>CycleRide.java</u></b>
 * </p>
 *
 * @author Michael Sammels
 * @version 08.10.2020
 */

public class CycleRide {
    private final int numberMiles;
    private final boolean cycleAlone;

    public CycleRide(int numberMiles, boolean cycleAlone) {
        this.numberMiles = numberMiles;
        this.cycleAlone = cycleAlone;
    }

    public int getNumberMiles() {
        return numberMiles;
    }

    public boolean isCycleAlone() {
        return cycleAlone;
    }

    public double getDifficultyFactor() {
        return 1.0;
    }
}
