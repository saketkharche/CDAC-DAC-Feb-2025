class Q4ReverseDigits {
    public static void main(String[] args) {
        int num = 1234;
        int reversedNum = 0;

        while (num != 0) {
            int digit = num % 10; // Get the last digit
            reversedNum = reversedNum * 10 + digit; // Build the reversed number
            num /= 10; // Remove the last digit
        }

        System.out.println("Reversed number: " + reversedNum);
    }
}
// Sample Output: Reversed number: 4321
