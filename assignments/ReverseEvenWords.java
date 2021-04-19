package week1.day2.assignments;

public class ReverseEvenWords {

	public static void main(String[] args) {

		/*
		 * Declare the input as Follow String test = "I am a software tester"; split the
		 * words and have it in an array
		 */
		String[] test = "I am a software tester".split(" ");
		String result = ""; // final result to get display at the end
		String rev = ""; // alternate wrds that get reversed

		for (int i = 0; i < test.length; i++) // Traverse through each word (using loop)
		{

			String words = test[i];

			if (i % 2 != 0) // find the odd index within the loop (use mod operator)
			{

				for (int j = words.length() - 1; j >= 0; j--) // print the even position words in reverse order using
																// another loop (nested loop)
				{

					/*
					 * Convert words to character array if the position is even else print the word
					 * as it is(concatenate space at the end).
					 */
					rev = rev + words.charAt(j);
				}
				result = result + rev + " "; // accumulate the same in the answer variable to preserve the order

				rev = "";
			}

			else
				result = result + test[i] + " ";
		}
		System.out.println(result); // reverse the even position words (output: I ma a erawtfos tester)

	}
}
