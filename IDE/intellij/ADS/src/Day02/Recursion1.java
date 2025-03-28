package Day02;

public class Recursion1 { // Fixed typo in class name
    // Correctly defined fibonacci method outside of main
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int number = 10; // Number of Fibonacci terms to print
        for (int i = 0; i < number; i++) { // Start from i = 0
            System.out.print(fibonacci(i) + " ");
        }
    }
}
