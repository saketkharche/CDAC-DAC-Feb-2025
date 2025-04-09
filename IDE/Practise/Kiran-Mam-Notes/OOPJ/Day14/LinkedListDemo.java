package Day14;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

	public static void main(String[] args) {
		//LinkedList<Integer> l1 = new LinkedList<Integer>();//Type safe
		List<Integer> l1 = new LinkedList<Integer>();//Upcasting
		l1.add(10);
		l1.add(20);
		l1.add(30);
		l1.add(40);
		l1.add(50);
		System.out.println(l1);
		
		//Working with LinkedList method
		LinkedList<Integer> l11 = new LinkedList<Integer>();
		l11.addFirst(5);
		l11.addLast(7);
		System.out.println(l11);
		
		//Not working with List interface check 
		//l1.addFirst(5);
		//l1.addLast(7);
		System.out.println(l1);
	}

}
