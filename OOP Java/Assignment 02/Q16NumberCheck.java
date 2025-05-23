import java.util.Scanner;

public class Q16NumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input from user
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        // Using ternary operator to determine if the number is positive, negative, or zero
        String result = (num > 0) ? "Positive" : (num < 0) ? "Negative" : "Zero";

        // Output the result
        System.out.println("The number is: " + result);
        
        sc.close();  // Closing the scanner to avoid resource leak
    }
}
