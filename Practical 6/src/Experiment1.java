import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

/**
 * <p>
 *     <b><u>CSCU9A3 - Practical 6</u></b>#
 *     <br />
 *     <b><u>Experiment1.java</u></b>
 * </p>
 *
 * @author Michael Sammels
 * @version 29.10.2020
 */

public class Experiment1 {
    public static void main(String[] args) {
        // Starting values to generate data
        int maxID = 100;
        int maxBalance = 10000;
        Random r = new Random(1);
        int numberOfAccounts = 10;

        // Create an array full of BankAccount objects
        BankAccount[] accounts = new BankAccount[numberOfAccounts];
        for (int i = 0; i < accounts.length; i++) {
            int id = r.nextInt(maxID); // Pick an ID number at random between 0 and maxID

            // Choose an initial for the person's name at random
            char nameInitial = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(r.nextInt(26));
            String name = nameInitial + ".GenericSurname"; // Make their name
            double balance = r.nextInt(maxBalance) / 100.0; // Choose a balance for the account in pounds

            accounts[i] = new BankAccount(id, name, balance);
        }

        // Create an array full of BankAccount objects
        r = new Random(1);
        BankAccount[] accounts2 = new BankAccount[numberOfAccounts];
        for (int i = 0; i < accounts2.length; i++) {
            int id = r.nextInt(maxID); // Pick an ID number at random between 0 and maxID

            // Choose an initial for the person's name at random
            char nameInitial = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(r.nextInt(26));
            String name = nameInitial + ".GenericSurname"; // Make their name
            double balance = r.nextInt(maxBalance) / 100.0; // Choose a balance for the account in pounds

            accounts2[i] = new BankAccount(id, name, balance);
        }

        // Create a hashset and fill with the BankAccount objects.
        HashSet<BankAccount> accountSet = new HashSet<>();
        Collections.addAll(accountSet, accounts);

        // Print summaries of the bank accounts on the console
        for (BankAccount ba : accounts2) {
            System.out.print(ba + ": "); // Remember, Java knows a string is needed here, so it calls ba.toString()
            System.out.println(accountSet.contains(ba));
        }
    }
}
