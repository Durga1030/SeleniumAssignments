package week1.day2.assignments;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {

		// Declare String Input as Follow String test = "changeme";
		String test = "changeme";

		// a) Convert the String to character array
		char[] characters = test.toCharArray();
		{
			// b) Traverse through each character (using loop)
			for (int i = 0; i < characters.length; i++) {
				// c)find the odd index within the loop (use mod operator)
				char c = characters[i];
				/*
				 * check if position of this character is odd. d)within the loop, change the
				 * character to uppercase, if the index is odd else don't change
				 */
				if (i % 2 != 0) {
					// convert it to upper case
					c = Character.toUpperCase(c);
//					System.out.println("Modified string is: " + c);
				}
				System.out.print(c);
				// index - 01234567
			}
//cHaNgEmE
		}
	}
}