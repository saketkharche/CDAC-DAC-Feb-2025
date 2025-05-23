import java.util.Scanner;

public class Q3SecondLargestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for array size
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Check for valid input
        if (n < 2) {
            System.out.println("Array must have at least two elements.");
            return;
        }

        int[] arr = new int[n];

        // Taking array input
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Finding the second largest element
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;  // Update second largest before updating largest
                largest = num;
            } else if (num > secondLargest && num < largest) {
                secondLargest = num; // Update second largest if it’s smaller than largest but greater than current secondLargest
            }
        }

        // Checking if there is a valid second largest element
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No second largest element (all elements may be the same).");
        } else {
            System.out.println("Second Largest Element: " + secondLargest);
        }

        scanner.close();
    }
}
