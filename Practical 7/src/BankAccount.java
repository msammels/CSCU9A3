/**
 * <p>
 * <b><u>CSCU9A3 - Practical 7</u></b>
 * <br />
 * <b><u>BankAccount.java</u></b>
 * </p>
 *
 * @author Michael Sammels
 * @version 11.11.2020
 */

public class BankAccount implements Comparable<BankAccount> {
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
    public int compareTo(BankAccount o) {
        return Double.compare(balance, o.balance);
    }
}
