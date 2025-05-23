package Day06;

// 1️⃣ Creating a Stack using an array
class Stack {
    private int arr[];  // 📦 Array to store stack elements
    private int top;    // 🎯 Top of stack
    private int size;   // 📏 Maximum size of stack

    public Stack(int size) { // 🏗️ Constructor
        this.size = size;
        arr = new int[size];  // 🛠️ Create array
        top = -1;             // 🔽 Empty stack
    }

    // 2️⃣ Push (Add element to stack)
    public void push(int value) {
        if (top == size - 1) { // 🚫 Stack Overflow
            System.out.println("Stack is full!");
            return;
        }
        arr[++top] = value;  // 🔼 Move top up and insert
        System.out.println(value + " pushed to stack");
    }

    // 3️⃣ Pop (Remove top element)
    public int pop() {
        if (top == -1) { // 🚫 Stack Underflow
            System.out.println("Stack is empty!");
            return -1;
        }
        return arr[top--];  // 🔽 Remove top element and move down
    }

    // 4️⃣ Peek (See top element)
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return arr[top];
    }

    // 5️⃣ Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
}

// 6️⃣ Main function to test the Stack
public class StackArray {
    public static void main(String[] args) {
        Stack stack = new Stack(5);  // 📦 Create a stack of size 5

        stack.push(10); // ➕ Push elements
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); // 🔍 Peek (should be 30)

        System.out.println("Popped: " + stack.pop()); // ❌ Pop (removes 30)
        System.out.println("Popped: " + stack.pop()); // ❌ Pop (removes 20)

        System.out.println("Is stack empty? " + stack.isEmpty()); // ❓ Check if empty
    }
}
