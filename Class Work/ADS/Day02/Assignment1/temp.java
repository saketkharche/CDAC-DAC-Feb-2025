import java.util.Scanner;

class Solution {
    // Recursive method to generate Fibonacci numbers
    static int fibo(int n) {
        // Base cases
        if (n <= 1) {
            return n;
        } else {
            // Recursively calculate Fibonacci number
            return fibo(n - 1) + fibo(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // Print the Fibonacci series
        System.out.print("[0");

        // Generate and print Fibonacci numbers
        for (int i = 1; i < n; i++) {
            System.out.print(", " + fibo(i));
        }

        System.out.print("]");
    }
}