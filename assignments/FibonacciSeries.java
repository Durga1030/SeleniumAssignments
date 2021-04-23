package week1.day2.assignments;

public class FibonacciSeries {

	public static void main(String[] args) {
		// input(range): 8 output: 0, 1, 1, 2, 3, 5, 8, 13

		// initialize 3 int variables (Tip: range = 8, firstNum = 0, secNum = 1, sum in
		// the series)

		int range = 8;
		int firstNum = 0;
		int secondNum = 1;
		int sum, i;
		System.out.print(firstNum + ", " + secondNum); // Print first number
		for (i = 2; i < range; ++i) // Iterate from 1 to the range

		/*
		 * If the iteration starts from 1 then the o/p will be 0, 1, 1, 2, 3, 5, 8, 13,
		 * 21. So i have started the iteration from 2 [where 0 and 1 are already
		 * assigned to print in previous step]
		 */

		{
			sum = firstNum + secondNum; // add first and second number assign to sum
			firstNum = secondNum;// Assign second number to the first number
			secondNum = sum; // Assign sum to the second number
			System.out.print(", " + sum); // print sum
		}

	}

}
