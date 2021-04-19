package week1.day2.assignments;

public class RemoveDuplicates {
	public static void main(String[] args) {

		// Use the declared String text as input
		String text = "We learn java basics as part of java sessions in java week1";
		int count = 0; // Initialize an integer variable as count
		char[] str = text.toCharArray(); // Split the String into array and iterate over it

		for (int i = 0; i < str.length; i++) {

			int j;
			for (j = 0; j < i; j++) { // Initialize another loop to check whether the word is there in the array
				if (str[i] == str[j]) {
					break;
				}
			}

			if (j == i) {
				str[count++] = str[i];
				System.out.print(str[i] + " ");
			}
		}
	}
}