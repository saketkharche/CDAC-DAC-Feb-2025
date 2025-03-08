import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();
        scanner.close(); // Close scanner after input

        // Check for leap year using logical operators
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        // Print result
        if (isLeap) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is NOT a Leap Year.");
        }
    }
}
