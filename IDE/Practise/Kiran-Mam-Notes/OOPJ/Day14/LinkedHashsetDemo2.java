package Day14;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashsetDemo2 {

	public static void main(String[] args) {
		Set<String> s1 = new LinkedHashSet<>();
		
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
