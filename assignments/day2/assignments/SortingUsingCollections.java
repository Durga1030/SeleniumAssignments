package week3.day2.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingUsingCollections {

	public static void main(String[] args) throws InterruptedException {

//		Declare a String array and add the Strings values as (HCL, Wipro,  Aspire Systems, CTS)		
		List<String> str = new ArrayList<String>();
		str.add("HCL");
		str.add("Wipro");
		str.add("Aspire Systems");
		str.add("CTS");

//		get the length of the array
		System.out.println("Length of Array: " + str.size());

//		sort the array	 and iterate in reverse order
		Collections.sort(str, Collections.reverseOrder());

//		print the array  > //		Required Output: Wipro, HCL , CTS, Aspire Systems
		System.out.println("Reversed Output: " + str);

	}

}
