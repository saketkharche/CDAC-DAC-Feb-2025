class Q5FibonacciSequence {
    public static void main(String[] args) {
        int a = 0, b = 1;
        System.out.print("Fibonacci sequence up to 21: ");
        while (a <= 21) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }
}
// Sample Output: Fibonacci sequence up to 21: 0 1 1 2 3 5 8 13 21
