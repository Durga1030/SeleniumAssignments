package week1.day2.assignments;

public class FindIntersection {

	public static void main(String[] args) {

		int a[] = { 3, 2, 11, 4, 6, 7 }; // Declare An array for {3,2,11,4,6,7};
		int b[] = { 1, 2, 8, 4, 9, 7 }; // Declare another array for {1,2,8,4,9,7};

		for (int i = 0; i < a.length; i++) // Declare for loop iterator from 0 to array length
		{
			for (int j = 0; j < b.length; j++) // Declare a nested for another array from 0 to array length
			{

				if (a[i] == b[j]) // Compare Both the arrays using a condition statement
				{

					System.out.println(a[i]); // Print the first array (shoud match item in both arrays)
				}

			}
		}

	}

}