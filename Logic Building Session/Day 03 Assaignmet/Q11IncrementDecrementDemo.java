class Q11IncrementDecrementDemo {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int result = ++a + b--;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("result = " + result);
    }
}
// Sample Output:
// a = 6
// b = 9
// result = 16
