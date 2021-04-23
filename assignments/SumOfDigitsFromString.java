package week1.day2.assignments;

public class SumOfDigitsFromString {

	public static void main(String[] args) {

		String s1 = "Tes12Le79af65"; // Declare a String text with the following value String text = "Tes12Le79af65";
		int sum = 0; // Declare a int variable sum

		for (int i = 0; i < s1.length(); i++) { // Iterate an array over the String

			char character = s1.charAt(i); // Get each character and check if it is a number using Character.isDigit()
			boolean isDigit = Character.isDigit(character);

			if (isDigit) {

				sum = sum + Character.getNumericValue(character); // Now covert char to int using
																	// Character.getNumericValue() and add it to sum
			}

		}

		System.out.print("Sum of digits from string is " + sum); // Now Print the value

	}

}
