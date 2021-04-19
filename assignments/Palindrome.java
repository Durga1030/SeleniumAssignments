package week1.day2.assignments;

public class Palindrome {

	public static void main(String[] args) {

		String data = "madam"; // Declare A String value as"madam"
		String rev = ""; // Declare another String rev value as ""

		for (int i = data.length() - 1; i >= 0; i--) // Iterate over the String in reverse order
			rev = rev + data.charAt(i); // Add the char into rev

		/*
		 * Compare the original String with the reversed String, if it is same then
		 * print palinDrome Hint: Use .equals or .equalsIgnoreCase when you compare a
		 * String
		 */

		if (data.equals(rev))
			System.out.println(data + " is a palindrome");
		else
			System.out.println(data + " is not a palindrome");

	}

}
