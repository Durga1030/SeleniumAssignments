package week1.day2.assignments;

public class SumOfDigitsUsingReplaceAll {

	public static void main(String[] args) {

		String s1 = "Tes12Le79af65"; // Declare a String text with the following value String text = "Tes12Le79af65";
		int sum = 0; // Declare a int variable sum

		s1 = s1.replaceAll("[^\\d.]", ""); // using replaceAll(), replace all the non-digits into ""

		System.out.println("Result after replaced all the non-digits:" + s1);

		char[] str = s1.toCharArray();

		for (int i = 0; i < str.length; i++) { // Iterate an array over the String

			char character = s1.charAt(i); // Get each character
			sum = sum + Character.getNumericValue(character); // Now covert char to int using
			// Character.getNumericValue() and add it to sum

		}

		System.out.println("Sum of digits from string is " + sum); // Now Print the value

	}

}
