package week3.day2.assignments;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RemoveDuplicates {
	public static void main(String[] args) {
// Declare a string
		String name = "PayPal India";
// Convert it to char array
		char[] charArray = name.toCharArray();
// Declare a set as charSet for Character
		Set<Character> charSet = new HashSet<Character>();
// Declare a set as dupCharSet for duplicate character
		Set<Character> dupCharSet = new HashSet<Character>();
// Iterate character array and add it into charSet
		for (int i = 0; i < charArray.length; i++) {
			char str = charArray[i];
			if (str != ' ') {
				charSet.add(new Character(charArray[i]));

			}
// If the character is already in the charSet then,add it to dupCharSet

			if (charSet.contains(charArray[i])) {
				dupCharSet.add(new Character(charArray[i]));

			}

		}

// Check the dupCharSet elements and remove those in the charSet
		if (dupCharSet.equals(charSet)) {
			charSet.remove(dupCharSet);
		}

// Print each character for CharSet
		Iterator result = charSet.iterator();
		System.out.println("The values in charset are :");
		while (result.hasNext()) {
			System.out.print(result.next() + " ");
		}
	}
}
