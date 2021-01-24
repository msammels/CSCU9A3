import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

/**
 * <p>
 *     <b><u>CSCU9A3 - Practical 6</u></b>#
 *     <br />
 *     <b><u>Experiment2.java</u></b>
 * </p>
 *
 * @author Michael Sammels
 * @version 29.10.2020
 */

public class Experiment2 {
    public static void main(String[] args) {
        // Starting values to generate data
        int maxID = 10000000;
        int maxBalance = 10000;
        Random r = new Random(1);
        int numberOfAccounts = 250000;

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

        // Create an array full of BankAccount objects - equal to the first half of the ones in the accounts array
        // - so these will be found in the hashset
        r = new Random(1);
        BankAccount[] accounts2 = new BankAccount[numberOfAccounts];
        for (int i = 0; i < accounts2.length / 2; i++) {
            int id = r.nextInt(maxID); // Pick an ID number at random between 0 and maxID

            // Choose an initial for the person's name at random
            char nameInitial = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(r.nextInt(26));
            String name = nameInitial + ".GenericSurname"; // Make their name
            double balance = r.nextInt(maxBalance) / 100.0; // Choose a balance for the account in pounds

            accounts2[i] = new BankAccount(id, name, balance);
        }

        // Fill the rest of accounts2 with randomly generated accounts, that won't be in the hashset
        r = new Random(10); // Different seed - totally different numbers
        for (int i = accounts2.length / 2; i < accounts2.length; i++) {
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


        // Check whether the second load of objects are present time the length of this process!
        int countPresent = 0;
        long start = System.currentTimeMillis();
        for (BankAccount ba : accounts2) {
            if (accountSet.contains(ba)) {
                countPresent++;
            }
        }
        long end = System.currentTimeMillis();

        System.out.println(countPresent + "/" + numberOfAccounts + " objects were found in the HashSet");
        System.out.println("Average time to add an account:");
        System.out.println("N\tTime");
        System.out.println(numberOfAccounts + "\t" + String.format("%.6f", ((double) (end - start) / numberOfAccounts)));
    }
}
