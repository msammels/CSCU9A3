/**
 * <p>
 *     <b><u>CSCU9A3 - Practical 3</u></b>#
 *     <br />
 *     <b><u>Weather.java</u></b>
 * </p>
 *
 * @author Michael Sammels
 * @version 08.10.2020
 */

public class Weather {
    protected int temp;
    protected int windSpeed;
    protected boolean isRaining;

    public Weather(int t, int wd, boolean r) {
        this.temp = t;
        this.windSpeed = wd;
        this.isRaining = r;
    }

    public int getTemp() {
        return temp;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public boolean getIsRaining() {
        return isRaining;
    }
}
