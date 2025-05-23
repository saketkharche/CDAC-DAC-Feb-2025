import java.util.Scanner;

public class Q2ReverseArray {
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

        // Reversing the array
        int left = 0, right = n - 1;
        while (left < right) {
            // Swap arr[left] and arr[right]
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Move pointers
            left++;
            right--;
        }

        // Output the reversed array
        System.out.println("Reversed Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
