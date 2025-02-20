class Q9LargestDigit {
    public static void main(String[] args) {
        int num = 4825;
        int largest = 0;

        while (num != 0) {
            int digit = num % 10;
            if (digit > largest) {
                largest = digit;
            }
            num /= 10;
        }

        System.out.println("Largest digit: " + largest);
    }
}
// Sample Output: Largest digit: 8
