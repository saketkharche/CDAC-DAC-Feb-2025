class Q6FirstFivePrimes {
    public static void main(String[] args) {
        System.out.println("First 5 prime numbers:");
        int count = 0;
        int num = 2; // Start checking from 2

        while (count < 5) {
            boolean isPrime = true;
<<<<<<< HEAD
            for (int i = 2; i * i <= num; i++) {
=======
            for (int i = 2; i <= Math.sqrt(num); i++) {
>>>>>>> b0f2c3c65d5222b5384f06a54ac9090bd351fb3a
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.print(num + " ");
                count++;
            }
            num++;
        }
        System.out.println();
    }
}
<<<<<<< HEAD
=======
// Sample Output:
// First 5 prime numbers:
// 2 3 5 7 11
>>>>>>> b0f2c3c65d5222b5384f06a54ac9090bd351fb3a
