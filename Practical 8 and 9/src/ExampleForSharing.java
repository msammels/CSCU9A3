import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ExampleForSharing {

	public static void main(String[] args) {
		// you can use this for development
//		String[][] test1 = {{"1", "1"}, {"2", "2"}, {"3", "2"}, {"1", "1"}, {"1", "1"}, {"2", "1"}, {"3", "2"}};
//		List<Integer> results = processQueries(test1);
//		System.out.println(results);

		// or jump straight to this
		long start = System.nanoTime();
		List<Integer> results = processQueries(loadFile("Data/input/input00.txt"));
		long end = System.nanoTime();
		
		System.out.println(checkOutput("Data/output/output00.txt", results) ? "Correct" : "Incorrect");
		
		System.out.println("Time: " + (end - start));
	}
	
	/**
	 * loads specified filename - format is line0=count of entries; line1 onwards = queries are x y
	 * this method doesn't impact on the timing, but you might want to
	 * make it more robust by adding some error checking 
	 * @param filename
	 * @return rows are queries; col0 is type (1/2/3) col1 is value
	 */
	public static String[][] loadFile(String filename) {
		
		try {
			
			List<String> allQueries = Files.readAllLines(Path.of(filename));
			
			String[][] rval = new String[allQueries.size() - 1][2]; // skip first one, that's the count
			
			for (int i = 0; i < rval.length; i++) {
				// assume first value is one digit, then space, then rest of string is second value
				rval[i][0] = allQueries.get(i + 1).substring(0,1);  // +1 as above
				rval[i][1] = allQueries.get(i + 1).substring(2);    // +1 as above
			}
			
			return rval;
			
		} catch (IOException e) {
			e.printStackTrace();

			return new String[0][0]; // didn't work? do nothing.
		}
		
	}
	
	/**
	 * you don't need to change this one!
	 * @param fileWithExpectedValues
	 * @param actualValues
	 * @return true if there is a one-to-one correspondence between all the actual values and those in the file
	 */
	public static boolean checkOutput(String fileWithExpectedValues, List<Integer> actualValues) {
		try {
			
			List<String> allResults = Files.readAllLines(Path.of(fileWithExpectedValues));
			
			boolean allEqual = true;
			for (int i = 0; i < allResults.size(); i++) {
				allEqual &= Integer.parseInt(allResults.get(i)) == actualValues.get(i);
			}
			
			return allEqual;
			
		} catch (IOException | IndexOutOfBoundsException e) {
			e.printStackTrace();
			return false; // didn't work? assume no match
		}
		
	}
	

	
	/**
	 * queries are space separated pairs
	 * 1 - insert
	 * 2 - delete
	 * 3 - check for frequency
	 * 
	 * this is a naive, and not particularly good, way to solve the problem
	 * you can replace any or all of the code inside this method with your solution
	 */
	public static List<Integer> processQueries(String[][] queries) {
		List<Integer> values = new ArrayList<>();
		List<Integer> toReturn = new ArrayList<>();
		
		for (String[] query : queries) {
			int value = Integer.parseInt(query[1]);
			if (query[0].equals("1")) {
				values.add(value);
			} else if (query[0].equals("2")) {
				values.remove(Integer.valueOf(value)); // need to use valueOf to make it an object, otherwise the list will try to remove the index rather than the value
			} else {
				boolean found = false;
				
				// naive way to do it.
				// look at each value in the array
				// scan the whole array counting how often that value appears
				// if we exceed the target count, try the next value
				outerLoop:
				for (int i = 0; i < values.size(); i++) {
					int count = 0;
					
					for (int j = 0; j < values.size(); j++) {
						// is this the value we're looking for? if so, increment count
						if (values.get(i).intValue() == values.get(j).intValue()) {
							count++;
						}
						
						// exceeded target count for this value, so try the next one
						if (count > value) {
							continue outerLoop;
						}
					}
					
					// if there were "value" occurrences of this number, then we've got a match
					if (count == value) {
						found = true;
						break outerLoop;
					}
				}
				
				// we found a match? add a 1 to the output; otherwise, add a 0
				toReturn.add(found ? 1 : 0);
			}
		}
		
		return toReturn;
		
	}
}
