package Day14;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

	public static void main(String[] args) {
		Map<Integer, String> m = new HashMap<Integer, String>();
		//<Key, Value>
		m.put(101, "Aditya");
		m.put(2, "Dhanush");
		m.put(3, "Shweta");
		m.put(4, "Shweta");
		m.put(4, "Shweta");//not allowed
		m.put(4, "Rohan");
		m.put(4, "Rohini");
		m.put(115, "");
		System.out.println(m);
		System.out.println(m.get(2));//
		m.remove(3);
		System.out.println(m);
		
		
		

	}

}
