package Day02.HomeWork;

public class Q4ReverseStringRecursion {
    // Recursive function to reverse a string
    public static String reverseString(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        // Example inputs
        String input1 = "CDACMumbai";
        String input2 = "Alice";

        // Output results
        System.out.println("Input: " + input1);
        System.out.println("Output: " + reverseString(input1));

        System.out.println("\nInput: " + input2);
        System.out.println("Output: " + reverseString(input2));
    }
}
