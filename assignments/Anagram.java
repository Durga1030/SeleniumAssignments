package week1.day2.assignments;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {

		String text1 = "posts";
		String text2 = "potss";
		boolean status = true;

		if (text1.length() == text2.length())
// Check length of the strings are same then Convert both Strings in to characters & Sort Both the arrays.

		{
			char[] t1 = text1.toCharArray();
			char[] t2 = text2.toCharArray();
			Arrays.sort(t1);
			Arrays.sort(t2);
			status = Arrays.equals(t1, t2);
			System.out.print("String result: ");
		}

		else {
			status = false;

		}
		if (status) // // Check both the arrays has same value
		{
			System.out.print(text1 + " & " + text2 + " are anagrams");
		} else {
			System.out.print(text1 + " & " + text2 + " are not anagrams");
		}
	}

}
