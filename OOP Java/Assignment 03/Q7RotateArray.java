import java.util.Scanner;

public class Q7RotateArray {
    // Function to reverse a part of the array
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Function to rotate the array to the right by k positions
    public static void rotateRight(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Handle cases where k > n

        // Step 1: Reverse the entire array
        reverse(arr, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverse(arr, 0, k - 1);

        // Step 3: Reverse the remaining n-k elements
        reverse(arr, k, n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for array size
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // Taking array input
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Taking input for k (rotation count)
        System.out.print("Enter the number of positions to rotate (k): ");
        int k = scanner.nextInt();

        // Rotating the array
        rotateRight(arr, k);

        // Output the rotated array
        System.out.println("Array after rotation:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
