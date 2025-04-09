package Day14;

import java.util.HashSet;
import java.util.Set;

public class HashsetDemo {

	public static void main(String[] args) {
		Set<String> s1 = new HashSet<>();
		
		s1.add("Mango");
		s1.add("Banana");
		s1.add("Grapes");
		s1.add("Mango");
		s1.add("Banana");
		s1.add("Grapes");
		s1.add("Grapes");
		s1.add("Grapes");
		s1.add("Grapes");
		s1.add("Grapes");
		
		System.out.println(s1);
		

	}

}
