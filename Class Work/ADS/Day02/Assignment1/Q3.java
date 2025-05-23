package Day02.Assignment1;

public class Q3 {
    // Recursive function to calculate factorial
    static int facto(int n) {
        // Base case: factorial(0) = 1 and factorial(1) = 1
        if (n == 0 || n == 1) {
            return 1;
        }

        // Recursive case: n * factorial(n - 1)
        return n * facto(n - 1);
    }

    public static void main(String[] args) {
        int n = 5; // Example input

        // Calling recursive factorial function and printing result
        System.out.println("Factorial of " + n + " is: " + facto(n));
    }
}
