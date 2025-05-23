package Day14;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo2 {

	public static void main(String[] args) {
		Map<Integer, String> m = new HashMap<Integer, String>();
		
		m.put(1, "Aditya");
		m.put(2, "Dhanush");
		m.put(3, "Shweta");
		m.put(4, "Shweta");
		m.put(4, "Shweta");//not allowed
		m.put(4, "Rohan");
		m.put(4, "Rohini");
		m.put(5, "");
		System.out.println(m);
		System.out.println(m.get(4));
		m.remove(3);
		System.out.println(m);
		
		
		

	}

}
