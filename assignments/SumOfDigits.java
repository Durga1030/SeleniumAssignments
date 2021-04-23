package week1.day2.assignments;

public class SumOfDigits {

	public static void main(String[] args) {

		int input = 123; // Declare your input (int)
		int sum; // Initialize an integer variable by name: sum
		int number = 0;
		sum = 0;
		System.out.print("Output: ");

		// This while loop condition is used to reverse the input value from 321 to 123

		while (input != 0) {
			number = number * 10 + input % 10;
			input = input / 10;
		}

		while (number > 0) {
			System.out.print(number % 10);
			sum = sum + (number % 10); // add that remainder to the sum
			number = number / 10; // get quotient of that number (tip: quotient should be same variable of loop
									// condition)
			if (number > 0) {
				System.out.print(" + "); // Print the quotient to confirm
			} else {

				System.out.print(" = ");
			}
		}
		System.out.print(sum); // print the final sum
	}

}
