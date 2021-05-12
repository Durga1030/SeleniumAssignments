package week4.day2;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PrintOnlyUnique {

	public static void main(String[] args) {

		String name = "durgaa";

// 		Convert String to char array
		char[] str = name.toCharArray();

// 		Create new set - [HashSet]
		Set<Character> uniqueChar = new HashSet<Character>();
//		Add each char to set
		for (int i = 0; i < str.length; i++) {
			uniqueChar.add(str[i]);

		}

// 		Finally print the set
		System.out.println(uniqueChar);

// 		Print the result in ascending order  [TreeSet]
		Set<Character> uniChars = new TreeSet<Character>();
		for (int i = 0; i < str.length; i++) {
			if (!uniChars.add(str[i])) {
				uniChars.remove(str[i]);
			}

		}
		System.out.println(uniChars);
	}

}
