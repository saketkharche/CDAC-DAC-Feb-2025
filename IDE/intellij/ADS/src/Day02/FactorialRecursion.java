package Day02;

public class FactorialRecursion {
    // Recursive function to calculate factorial
    public static int factorial(int n) {
        if (n == 0 || n == 1) { // Base case
            return 1;
        }
        return n * factorial(n - 1); // Recursive call
    }

    public static void main(String[] args) {
        int number = 5; // Change this to test with other values
        System.out.println("Factorial of " + number + " is: " + factorial(number));
    }
}
