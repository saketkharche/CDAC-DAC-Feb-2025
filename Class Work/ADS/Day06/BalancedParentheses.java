package Day06;

import java.util.Scanner; // 📥 Import Scanner for user input

// 1️⃣ Custom Stack Class (Using an Array)
class MyStack {
    private char[] stack;  // 📦 Array to store stack elements
    private int top;       // 🎯 Top of stack
    private int size;      // 📏 Maximum size of stack

    public MyStack(int size) { // 🏗️ Constructor
        this.size = size;
        stack = new char[size]; // 🛠️ Create array
        top = -1; // 🔽 Empty stack initially
    }

    // 2️⃣ Push (Add element to stack)
    public void push(char value) {
        if (top == size - 1) { // 🚫 Stack Overflow
            System.out.println("Stack is full!");
            return;
        }
        stack[++top] = value; // 🔼 Move top up and insert
    }

    // 3️⃣ Pop (Remove top element)
    public char pop() {
        if (top == -1) { // 🚫 Stack Underflow
            return '\0'; // Return null character if stack is empty
        }
        return stack[top--]; // 🔽 Remove top element and move down
    }

    // 4️⃣ Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
}

// 5️⃣ Balanced Parentheses Check
public class BalancedParentheses {
    public static boolean isBalanced(String str) {
        MyStack stack = new MyStack(str.length()); // 🏗️ Create stack of required size

        for (char ch : str.toCharArray()) { // 🔄 Loop through each character
            if (ch == '(' || ch == '{' || ch == '[') { // 📥 Push opening brackets
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') { // 📤 Closing bracket
                if (stack.isEmpty()) return false; // 🚨 Stack empty? Not balanced!

                char top = stack.pop(); // 🚪 Pop the last opening bracket

                // ❌ Check if closing matches opening
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty(); // ✅ If stack is empty at end, it's balanced
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 🛠️ Take user input
        System.out.print("Enter a string with brackets: ");
        String input = scanner.nextLine(); // 📥 Read input

        if (isBalanced(input)) {
            System.out.println("✅ Balanced!");
        } else {
            System.out.println("❌ Not Balanced!");
        }

        scanner.close(); // 🚪 Close scanner
    }
}
