package Day02.HomeWork;

import java.util.Scanner;

public class Q1 {

    // Recursive function to calculate the sum of the series
    public static double findSum(int N) {
        // Base case: If N is 1, return 1
        if (N == 1) {
            return 1.0;
        }

        double currentTerm;
        // If N is even, subtract 1/N
        if (N % 2 == 0) {
            currentTerm = -1.0 / N;
        }
        // If N is odd, add 1/N
        else {
            currentTerm = 1.0 / N;
        }

        // Recursively calculate the sum of the remaining terms
        return currentTerm + findSum(N - 1);
    }

    public static void main(String[] args) {
        // Creating a scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Asking user for input
        System.out.print("Enter a positive integer (N): ");
        int N = sc.nextInt();

        // Close the scanner to prevent memory leaks
        sc.close();

        // Validate input (Ensure N is positive)
        if (N <= 0) {
            System.out.println("Please enter a positive integer greater than 0.");
            return;
        }

        // Calculate and display the sum of the series
        double result = findSum(N);
        System.out.printf("Sum of the series for N = %d is: %.10f\n", N, result);
    }
}
