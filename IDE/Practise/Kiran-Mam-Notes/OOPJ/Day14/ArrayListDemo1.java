package Day14;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo1 {

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
		System.out.println("-------1------");
		
		//Traversing : Method 1
		for(int i=0;i< a11.size();i++) {
			System.out.println(a11.get(i));
		}
		System.out.println("------2-------");
		//Traversing : Method 2
		for(String x : a11) {
			System.out.println(x);
		}
		
		System.out.println("--------3-----");
		//Traversing : Method 3
		Iterator<String> itr = a11.iterator();
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}

	}

}
