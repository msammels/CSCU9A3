/**
 * <p>
 *     <b><u>CSCU9A3 - Practical 6</u></b>#
 *     <br />
 *     <b><u>BankAccount.java</u></b>
 * </p>
 *
 * @author Michael Sammels
 * @version 29.10.2020
 */

public class BankAccount {
    private final int idNumber;
    private final String name;
    private final double balance;

    public BankAccount(int idNumber, String name, double initialBalance) {
        this.idNumber = idNumber;
        this.name = name;
        this.balance = initialBalance;
    }

    @Override
    public String toString() {
        return "Account [ID=" + idNumber + ", name=" + name + ", balance=£" + balance + "]";
    }

    @Override
    public boolean equals(Object obj) {
        return this.idNumber == ((BankAccount) obj).idNumber;
    }

    @Override
    public int hashCode() {
        // we could just return idNumber here as it's already an int but this is to illustrate that we can do other
        // things to produce a valid hashCode, which must always be an int.
        return Integer.hashCode(this.idNumber);
    }
}
