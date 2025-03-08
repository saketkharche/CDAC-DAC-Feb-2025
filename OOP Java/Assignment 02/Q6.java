import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter first number (a): ");
        int a = scanner.nextInt();

        System.out.print("Enter second number (b): ");
        int b = scanner.nextInt();

        System.out.print("Enter third number (c): ");
        int c = scanner.nextInt();

        scanner.close(); // Close scanner after input

        // Find the largest using the ternary operator
        int largest = (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);

        // Display result
        System.out.println("The largest number is: " + largest);
    }
}
