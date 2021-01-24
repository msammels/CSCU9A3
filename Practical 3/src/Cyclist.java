/**
 * <p>
 *     <b><u>CSCU9A3 - Practical 3</u></b>#
 *     <br />
 *     <b><u>Cyclist.java</u></b>
 * </p>
 *
 * @author Michael Sammels
 * @version 08.10.2020
 */

public class Cyclist {
    private final String competency;
    private final int numYearsExperience;

    public Cyclist(String competency, int numYearsExperience) {
        this.competency = competency;
        this.numYearsExperience = numYearsExperience;
    }

    public int getNumYearsExperience() {
        return numYearsExperience;
    }

    public boolean isBeginner() {
        return competency.equalsIgnoreCase("Beginner");
    }

    public boolean isIntermediate() {
        return competency.equalsIgnoreCase("Intermediate");
    }

    public boolean isAdvanced() {
        return competency.equalsIgnoreCase("Advanced");
    }
}
