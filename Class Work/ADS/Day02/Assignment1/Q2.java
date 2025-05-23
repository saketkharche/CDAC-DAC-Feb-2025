package Day02.Assignment1;

import java.util.Scanner;

public class Q2 {
    // Recursive function to compute the sum of the series
    static double sumOfSeries(int n) {
        if (n == 1) {
            return 1.0; // Base case: return 1 for n = 1
        }
        double term;
        if (n % 2 == 0) {
            term = -1.0 / n; // Negative for even n
        } else {
            term = 1.0 / n;  // Positive for odd n
        }
        return term + sumOfSeries(n - 1); // Recursion step
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Read input
        sc.close();

        System.out.printf("%.7f\n", sumOfSeries(n)); // Print result with precision
    }
}
