import java.util.Arrays;
import java.util.Random;

/**
 * <p>
 *     <b><u>CSCU9A3 - Practical 7</u></b>
 *     <br />
 *     <b><u>SortingExperiment.java</u></b>
 * </p>
 *
 * @author Michael Sammels
 * @version 11.11.2020
 */

public class SortingExperiment {
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

        // Print summaries of the bank accounts on the console
        System.out.println("Before...");
        for (BankAccount ba : accounts) {
            System.out.println(ba); // Remember, Java knows a string is needed here, so it calls ba.toString()
        }

        Arrays.sort(accounts);

        System.out.println("After...");
        for (BankAccount ba : accounts) {
            System.out.println(ba); // Remember, Java knows a string is needed here, so it calls ba.toString()
        }
    }
}
