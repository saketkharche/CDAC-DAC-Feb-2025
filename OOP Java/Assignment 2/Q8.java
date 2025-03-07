import java.util.Scanner;

public class Q8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take boolean inputs from user
        System.out.print("Enter first boolean value (true/false): ");
        boolean a = scanner.nextBoolean();

        System.out.print("Enter second boolean value (true/false): ");
        boolean b = scanner.nextBoolean();

        System.out.print("Enter third boolean value (true/false): ");
        boolean c = scanner.nextBoolean();

        scanner.close(); // Close scanner after input

        // Check if at least two values are true using logical operators
        boolean result = (a && b) || (b && c) || (a && c);

        // Print result
        System.out.println("At least two values are true: " + result);
    }
}
