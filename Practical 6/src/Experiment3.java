import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * <p>
 *     <b><u>CSCU9A3 - Practical 6</u></b>#
 *     <br />
 *     <b><u>Experiment3.java</u></b>
 * </p>
 *
 * @author Michael Sammels
 * @version 29.10.2020
 */

public class Experiment3 {
    public static void main(String[] args) {
        Map<String, BankAccount> accounts = new HashMap<>();

        // add some accounts to the map, using some other value as a key
        accounts.put("acc143", new BankAccount(1, "J. Jones", 100));
        accounts.put("acc146", new BankAccount(2, "B. Gumble", 200));
        accounts.put("acc123", new BankAccount(3, "D.J. Quimby", 105000));
        accounts.put("acc177", new BankAccount(4, "M. Szyslak", 31));
        accounts.put("acc204", new BankAccount(5, "C. Carlson", 575));

        // retrieve any account by its "key" value
        System.out.println("Retrieve values...");
        System.out.println(accounts.get("acc146")); // this one exists
        System.out.println(accounts.get("acc133")); // this one doesn't

        // does the map contain a particular key?
        // this will run in near-constant time if the hashcode function
        // for the keys is a good one
        // there is also a containsValue(), but check the
        // API docs - this will probably run in O(n) time
        System.out.println("Contains keys?");
        System.out.println(accounts.containsKey("acc146")); // this one exists
        System.out.println(accounts.containsKey("acc133")); // this one doesn't

        // iterate over all the keys
        // note, there is no particular order to the keys as they are retrieved
        System.out.println("All keys...");
        for (String k : accounts.keySet()) {
            System.out.println(k);
        }

        // iterate over all the values
        System.out.println("All values...");
        for (BankAccount v : accounts.values()) {
            System.out.println(v);
        }

        // iterate over all the key/value pairs
        System.out.println("All key/values...");
        for (Entry<String, BankAccount> e : accounts.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }

        // let's try the same with a TreeMap
		Map<String, BankAccount> accounts2 = new TreeMap<>(accounts);

        // iterate over all the key/value pairs
        // these will be in ascending order of the keys!
        // BUT put/get operations will be O(log n) rather than
        // O(1), so use carefully!
        // Other map types also exist...
        System.out.println("Tree Map all key/values...");
        for (Entry<String, BankAccount> e : accounts2.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
}
