package week3.day2.assignments;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ReverseMap {
	public static void main(String[] args) {

//	Insert elements to the map
		/*
		 * Input: - Employee Info: Emp_id|Emp_name 100 Hari 101 Naveen 102 Sam 104
		 * Balaji
		 */

		
		TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
		map.put(100, "Hari");
		map.put(101, "Naveen");
		map.put(102, "Sam");
		map.put(104, "Balaji");

		System.out.println(map);

		}

	}
}
