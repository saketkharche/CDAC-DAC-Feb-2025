package stk;

import java.util.Scanner;

class Stack2 { 
	static final int MAX = 7; 
	int top; 
	int a[] = new int[MAX]; // Maximum size of Stack 

	boolean isEmpty() 
	{ 
		return (top < 0); 
	} 
	Stack2() 
	{ 
		top = -1; 
	} 
	boolean push(int x) 
	{ 
		if (top >= (MAX - 1)) { 
			System.out.println("Stack Overflow"); 
			return false; 
		} 
		else { 
			a[++top] = x; 
			System.out.println(x + " pushed into stack"); 
			return true; 
		} 
	} 
	int pop() 
	{ 
		if (top < 0) { 
			System.out.println("Stack Underflow"); 
			return 0; 
		} 
		else { 
			int x = a[top--]; 
			return x; 
		} 
	} 
	int peek() 
	{ 
		if (top < 0) { 
			System.out.println("Stack Underflow"); 
			return 0; 
		} 
		else { 
			int x = a[top]; 
			return x; 
		} 
	} 
} 

public class StackApp1 {

	public static void main(String[] args) {
	    Stack2 s = new Stack2(); 
        Scanner in = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n******** MENU *******");
            System.out.println("1. PUSH");
            System.out.println("2. POP");
            System.out.println("3. PEEK");
            System.out.println("4. IS EMPTY?");
            System.out.println("5. EXIT");
            System.out.print("Enter your choice: ");
            
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value: ");
                    s.push(in.nextInt());
                    break;
                case 2:
                    int popped = s.pop();
                    if (popped != -1)
                        System.out.println("Popped element: " + popped);
                    break;
                case 3:
                    int top = s.peek();
                    if (top != -1)
                        System.out.println("Top element: " + top);
                    break;
                case 4:
                    System.out.println("Is stack empty? " + s.isEmpty());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    in.close();
                    System.exit(0);
                default:
                    System.out.println("Wrong Choice! Please enter a valid option.");
            }
            System.out.print("Do you want to continue? (1 for Yes, 0 for No): ");
        } while (in.nextInt() == 1);

        in.close();
    }

	

}
