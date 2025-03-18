import java.util.Scanner;

public class Q4DivisibleByThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        scanner.close();

        int sum = 0;
        int n = number;

        while (n > 0) {
            // Extract last digit using subtraction (no modulus)
            int lastDigit = n - ((n >> 3) * 10); 
            sum = sum + lastDigit;

            // Remove last digit using subtraction and right shift
            n = n - lastDigit;
            n = n >> 1;
        }

        // Reduce sum by subtracting 3 repeatedly
        while (sum >= 3) {
            sum = sum - 3;
        }

        // Check divisibility
        if (sum == 0) {
            System.out.println(number + " is divisible by 3");
        } else {
            System.out.println(number + " is NOT divisible by 3");
        }
    }
}
