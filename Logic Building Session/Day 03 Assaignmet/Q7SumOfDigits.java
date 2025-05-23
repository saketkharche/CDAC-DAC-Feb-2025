class Q7SumOfDigits {
    public static void main(String[] args) {
        int num = 9876;
        int sum = 0;

        while (num != 0) {
            int digit = num % 10; // Get the last digit
            sum += digit; // Add it to the sum
            num /= 10; // Remove the last digit
        }

        System.out.println("Sum of the digits: " + sum);
    }
}
// Sample Output: Sum of the digits: 30
