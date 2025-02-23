<<<<<<< HEAD
    class Q2FactorialOfTen {
=======
class Q2FactorialOfTen {
>>>>>>> b0f2c3c65d5222b5384f06a54ac9090bd351fb3a
    public static void main(String[] args) {
        long factorial = 1; // Use long to avoid integer overflow
        for (int i = 1; i <= 10; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of 10: " + factorial);
    }
}
// Sample Output: Factorial of 10: 3628800
