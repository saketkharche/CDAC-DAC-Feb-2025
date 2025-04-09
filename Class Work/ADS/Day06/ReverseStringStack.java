package Day06;

import java.util.Stack;

public class ReverseStringStack {
    public static String reverseString(String input) {
        // Create an empty stack
        Stack<Character> stack = new Stack<>();

        // Push all characters of the input string onto the stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Pop characters from the stack to reverse the string
        StringBuilder reversedString = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }

        return reversedString.toString();
    }

    public static void main(String[] args) {
        String input = "hello";
        System.out.println("Original string: " + input);
        System.out.println("Reversed string: " + reverseString(input));
    }
}