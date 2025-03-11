import java.util.Scanner;

public class Q9MissingNumber {

    public static int findMissingNumber(int[] arr, int n) {
        int expectedSum = n * (n + 1) / 2; // Sum of first n natural numbers
        int actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return expectedSum - actualSum; // Missing number = Expected - Actual
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input
        System.out.print("Enter the size of the array (n-1): ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Find and display the missing number
        int missingNumber = findMissingNumber(arr, n + 1);
        System.out.println("The missing number is: " + missingNumber);

        scanner.close();
    }
}
