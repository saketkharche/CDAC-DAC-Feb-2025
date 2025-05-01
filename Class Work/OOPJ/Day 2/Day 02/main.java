// Java program to illustrate the Concept
// of Autoboxing and Unboxing

// Importing required classes
import java.io.*;

// Main class
class main {

	// Main driver method
	public static void main(String[] args)
	{

		// Creating an Integer Object
		// with custom value say it be 10
		Integer i = new Integer(10);

		// Unboxing the Object
		int i1 = i;

		// Print statements
		System.out.println("Value of i:" + i);
		System.out.println("Value of i1: " + i1);

		// Autoboxing of character
		Character gfg = 'a';

		// Auto-unboxing of Character
		char ch = gfg;

		// Print statements
		System.out.println("Value of ch: " + ch);
		System.out.println(" Value of gfg: " + gfg);
	}
}
