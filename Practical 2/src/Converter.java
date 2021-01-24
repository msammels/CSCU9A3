import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * <p>
 *     <b><u>CSCU9A3 - Practical 2</u></b>
 *     <br />
 *     <b><u>Converter.java</u></b>
 * </p>
 * Converter class which uses Colin's top secret rules to calculate the estimated duration of a cycle given
 * certain information about the cyclist, the route and the weather.
 *
 * @author Michael Sammels
 * @version 07.10.2020
 */

public class Converter {
    public double mph2kph(double mph)   { return mph * 1.609; }                 // Miles per hour to kilometers per hour
    public double c2f(double tmp)       { return celsius_to_fahrenheit(tmp); }  // Celsius to Fahrenheit
    public double gbp2usd(double mon)   { return pounds_to_dollars(mon); }      // Pounds to Dollars
    public double sec2hrs(double sec)   { return sec / 3600; }                  // Seconds to hours

    public String mph2kph_printing(double mph) {
        // The DecimalFormat is needed to configure the precision (number of decimals) of the double variable when
        // converting to string
        return mph + " mph = " + new DecimalFormat("#.#",
                DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(mph2kph(mph)) + " kph";
    }

    public boolean mph2kph_compare(double mph1, double mph2) { return mph2kph(mph1) >= mph2kph(mph2); }
    public double celsius_to_fahrenheit(double celsius) { return (celsius * 9.0 / 5.0) + 32.0; }

    public double pounds_to_dollars(double pounds) {
        double rate = 0.77;

        return pounds * rate;
    }

    public double[] convert_array(String type, double[] values) {
        double[] out_values = new double[values.length];

        // Converting mph2kph
        if (type.equals("mph2kph")) {
            for (int i = 0; i < values.length; i++) {
                out_values[i] = mph2kph(values[i]);
            }
        }

        // Converting celsius to fahrenheit
        if (type.equals("c2f")) {
            for (int i = 0; i < values.length; i++) {
                out_values[i] = c2f(values[i]);
            }
        }

        // Converting pounds to dollars
        if (type.equals("gbp2usd")) {
            for (int i = 0; i < values.length; i++) {
                out_values[i] = gbp2usd(values[i]);
            }
        }

        // Converting seconds to hours
        if (type.equals("sec2hrs")) {
            for (int i = 0; i < values.length; i++) {
                out_values[i] = sec2hrs(values[i]);
            }
        }

        return out_values;
    }
}
