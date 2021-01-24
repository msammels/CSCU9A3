import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * <p>
 *     <b><u>CSCU9A3 - Practical 2</u></b>
 *     <br />
 *     <b><u>ConverterTest.java</u></b>
 * </p>
 *
 * @author Michael Sammels
 * @version 07.10.2020
 */

public class ConverterTest {
    private static final double ACCURACY = 0.05;
    private static Converter converter;

    @BeforeAll
    public static void setup() {
        // This method only setups the unit testing. In other words, this method is responsible for instantiating or
        // initializing any variables that unit test methods need. There are different annotations as can be seen here
        // https://junit.org/junit5/docs/current/user-guide/
        // https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/org/junit/jupiter/api/package-summary.html

        converter = new Converter();
    }

    @Test
    public void test_mph2kph() {
        // Test convert mph to kph -- comparing doubles using assertEquals
        assertEquals("mph2kmh failed:", 38.6243, converter.mph2kph(24), ACCURACY);
        assertEquals("mph2kmh failed: ", 96.5606, converter.mph2kph(60), ACCURACY);
    }

    @Test
    public void test_mph2kph_printing() {
        // Test printing mph to kph -- comparing Strings using arrestEquals
        assertEquals("mph2kmh printing failed: ", "60.0 mph = 96.5 kph",
                converter.mph2kph_printing(60));
    }

    @Test
    public void test_mph2kph_compare() {
        // Test comparison between two mph values -- comparing integers using assertFalse (boolean)
        assertFalse("mph2km comparison failed: ", converter.mph2kph_compare(24, 60));
    }

    @Test
    public void test_celsius_to_fahrenheit() {
        // Test comparison between two temperature values -- comparing doubles using assertEquals
        assertEquals("celsius to fahrenheit failed: ", 53.6, converter.celsius_to_fahrenheit(12.0), ACCURACY);
    }

    @Test
    public void test_pounds_to_dollars() {
        // Test comparison between two monetary values -- comparing doubles using assertEquals
        assertEquals("pounds to dollars failed: ", 23.1, converter.pounds_to_dollars(30), ACCURACY);
    }

    @Test
    public void test_seconds_to_hours() {
        // Test comparison between two time values -- comparing doubles using assertEquals
        assertEquals("seconds to hours failed: ", 2.73, converter.sec2hrs(10000), ACCURACY);
    }

    @Test
    public void test_convert_array() {
        // Test comparison between arrays -- comparing integers using assertArrayEquals

        /* mph2kph */
        double[] mph2kph_expected = new double[] {converter.mph2kph(24), converter.mph2kph(60)};
        double[] mph2kph_actual = converter.convert_array("mph2kph", new double[] {24, 60});

        /* c2f */
        double[] c2f_expected = new double[] {converter.c2f(30)};
        double[] c2f_actual = converter.convert_array("c2f", new double[] {30});

        /* gbp2usd */
        double[] gbp2usd_expected = new double[] {converter.gbp2usd(30)};
        double[] gbp2usd_actual = converter.convert_array("gbp2usd", new double[] {30});

        /* sec2hrs */
        double[] sec2hrs_expected = new double[] {converter.sec2hrs(10000)};
        double[] sec2hrs_actual = converter.convert_array("sec2hrs", new double[] {10000});

        assertArrayEquals("mph2kph_expected failed: ",  mph2kph_expected, mph2kph_actual, ACCURACY);
        assertArrayEquals("c2f_expected failed: ",      c2f_expected, c2f_actual, ACCURACY);
        assertArrayEquals("gbp2usd_expected failed: ",  gbp2usd_expected, gbp2usd_actual, ACCURACY);
        assertArrayEquals("sec2hrs_expected failed: ",  sec2hrs_expected, sec2hrs_actual, ACCURACY);
    }
}
