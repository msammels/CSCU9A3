/**
 * <p>
 *     <b><u>CSCU9A3 - Practical 5</u></b>#
 *     <br />
 *     <b><u>Customer.java</u></b>
 * </p>
 * <p>
 *     Representation of a shop customer
 * </p>
 *
 * @author Michael Sammels
 * @version 23.10.2020
 */

public class Customer {
    // For this we don't really care what attributes a customer might have, hence the customer class is empty.
    // In a "real" system this wouldn't be the case...

    public boolean buyingFancyCoffee;

    public Customer() {

    }

    public Customer(boolean buyingFancyCoffee) {
        this.buyingFancyCoffee = buyingFancyCoffee;
    }
}
