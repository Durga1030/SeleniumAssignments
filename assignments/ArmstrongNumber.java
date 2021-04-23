package week1.day2.assignments;

public class ArmstrongNumber {
	public static void main(String[] args) {

		// #1) Declare your input
		// #2) Declare 3 more int variables as calculated, remainder, original (Tip:
		// Initialize calculated alone)

		int n = 153;
		int calculated = 0, reminder, originalValue;
		originalValue = n; // Assign input into variable original
		String str = Integer.toString(n);
		// System.out.println("Validation of ArmStrong Number: ");
		while (n > 0) // Use loop to calculate: use while loop to set condition until the number
						// greater than 0
		{
			for (int i = 0; i < str.length(); i++) {
				reminder = n % 10; // Within loop: get the remainder when done by 10 (Tip: Use Mod operator)

				n = n / 10; // Within loop: get the quotient when done by 10 (Tip: Assign the result to
							// input)

				calculated = calculated + (reminder * reminder * reminder); // Within loop: Add calculated with the cube
																			// of remainder & assign it to calculated

				// Printing the characters at each position
				System.out.print("(" + str.charAt(i) + "*" + str.charAt(i) + "*" + str.charAt(i) + ")");

				if (n > 0) {
					System.out.print(" + "); // Print the quotient to confirm
				} else {

					System.out.print(" = ");
				}

			}

		}
		if (calculated == originalValue) // Check whether calculated and original are same
		{
			System.out.print(calculated + " is an armstrong number"); // //When it matches print it as Armstrong number
		} else
			System.out.println(calculated + " is not an armstrong number");

	}
}
