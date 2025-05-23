package Day14;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		ArrayList a1 = new ArrayList();//Non type safe
		ArrayList<String> a11 = new ArrayList<>();//Type safe
		a11.add("Tushar");
		a11.add("Kiran");
		a11.add("Pratik");
		a11.add("Isha");
		a11.add("Pratik");
		System.out.println(a11);
		
		System.out.println(a11.get(0));
		System.out.println(a11.get(3));
		
		a11.remove(0);
		System.out.println(a11);
		a11.remove("Kiran");
		System.out.println(a11);
		
		
		

	}

}
