import java.util.Scanner;

public class Q6RemoveDuplicatesSortedArray {
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0; // Edge case: empty array

        int i = 0; // Slow pointer for unique elements

        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) { // Found a new unique element
                i++; // Move slow pointer
                arr[i] = arr[j]; // Update unique position
            }
        }
        
        return i + 1; // New size of the unique elements array
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for array size
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // Taking sorted array input
        System.out.println("Enter " + n + " sorted elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Removing duplicates
        int newLength = removeDuplicates(arr);

        // Output the modified array
        System.out.println("Array after removing duplicates:");
        for (int i = 0; i < newLength; i++) {
            System.out.print(arr[i] + " ");
        }

        scanner.close();
    }
}
