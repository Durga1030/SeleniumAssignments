package week3.day2.assignments;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterOcurrences {
	public static void main(String[] args) {

//	Assignment : Map --  Write a Java Program to Find the Occurance of Each Character in the given String : "welcome to Selenium automation"

//	1. Create a String with your name as value
		String input = "welcome to Selenium automation";

//	2. Convert the string into a char array		
		char[] charArray = input.toCharArray();

//	3. Create an empty Map<Character,Integer>
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
// 4. Iterate over the array

		for (int i = 0; i < charArray.length; i++) {
// 5. Check whether the Map contains the Character
			if (map.containsKey(charArray[i])) {
// 6. If it contains then increment the key (+1)
				Integer value = map.get(charArray[i]);
// 7. Add the character in the map & set the value as 1
				int newValue = value + 1;
				map.put(charArray[i], newValue);
			} else {
				map.put(charArray[i], 1);
			}
		}
// 8. Print the Map
		System.out.println(map);
	}
}
