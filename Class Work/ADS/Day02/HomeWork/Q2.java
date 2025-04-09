package Day02.HomeWork;

import java.util.Scanner;

public class Q2 {

    // Recursive function to print the multiplication table
    static void MulTab(int n, int m) {
        // Base case: Stop when multiplier reaches 0
        if (m == 0) {
            return;
        }

        // Recursive call for previous values
        MulTab(n, m - 1);

        // Print the current multiplication step
        System.out.println(n + " x " + m + " = " + (n * m));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input from user
        System.out.print("Enter a number (N) for multiplication table: ");
        int n = sc.nextInt();

        System.out.print("Enter the range (M) for multiplication table: ");
        int m = sc.nextInt();

        sc.close(); // Close scanner to prevent memory leaks

        System.out.println("Multiplication Table of " + n + " up to " + m + ":");
        MulTab(n, m); // Call recursive function to print the table
    }
}
