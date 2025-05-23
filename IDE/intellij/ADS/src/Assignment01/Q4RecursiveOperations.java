package Assignment01;

public class Q4RecursiveOperations {
    public static void main(String[] args) {
        int num = 7;
        String str = "racecar";
        int numDigits = 1234;
        int fibIndex = 6;
        int a = 2, b = 5;

        // Check if number is prime
        System.out.println("Is prime: " + isPrime(num, 2));

        // Check if string is palindrome
        System.out.println("Is '" + str + "' a palindrome? " + isPalindrome(str, 0, str.length() - 1));

        // Sum of digits
        System.out.println("Sum of digits of " + numDigits + ": " + sumOfDigits(numDigits));

        // Fibonacci number
        System.out.println("Fibonacci(" + fibIndex + "): " + fibonacci(fibIndex));

        // Power calculation
        System.out.println(a + "^" + b + " = " + power(a, b));
    }

    // Recursive function to check if a number is prime
    public static boolean isPrime(int num, int divisor) {
        if (num <= 2) return num == 2;
        if (num % divisor == 0) return false;
        if (divisor * divisor > num) return true;
        return isPrime(num, divisor + 1);
    }

    // Recursive function to check if a string is a palindrome
    public static boolean isPalindrome(String str, int left, int right) {
        if (left >= right) return true;
        if (str.charAt(left) != str.charAt(right)) return false;
        return isPalindrome(str, left + 1, right - 1);
    }

    // Recursive function to find sum of digits
    public static int sumOfDigits(int num) {
        if (num == 0) return 0;
        return (num % 10) + sumOfDigits(num / 10);
    }

    // Recursive function to find nth Fibonacci number
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Recursive function to calculate a^b
    public static int power(int a, int b) {
        if (b == 0) return 1;
        return a * power(a, b - 1);
    }
}
