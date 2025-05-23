package Day14;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo3 {

	public static void main(String[] args) {
		Map<Integer, String> m = new LinkedHashMap<Integer, String>();
		//<Key, Value>
		m.put(101, "Aditya");
		m.put(2, "Dhanush");
		m.put(3, "Shweta");
		m.put(4, "Shweta");
		m.put(5, "Rohan");
		m.put(6, "Rohini");
		m.put(7, "");
		m.put(8, "");
		m.put(9, "");
		System.out.println(m);
		System.out.println(m.get(5));//
		m.remove(3);
		System.out.println(m);
		
		
		

	}

}
