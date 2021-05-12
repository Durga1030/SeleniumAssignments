package week4.day2;

import java.util.Map;
import java.util.TreeMap;

public class FindNumberOccurrances {

	public static void main(String[] args) {

		int[] num = { 2, 3, -1, 4, 5, -1, -7, 7, 2, 4, 3, -4, -1, -7, 8, 9 };

		Map<Integer, Integer> number = new TreeMap<Integer, Integer>();

		for (int i = 0; i < num.length; i++) {

			if (number.containsKey(num[i])) {

				Integer value = number.get(num[i]);
				int newVal = value + 1;

				number.put(num[i], newVal);
			} else {
				number.put(num[i], 1);
			}

		}

		System.out.println(number);

	}

}
