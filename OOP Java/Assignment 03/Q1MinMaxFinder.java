import java.util.Scanner;

public class Q1MinMaxFinder {
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

        // Finding min and max
        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i]; // Update min if a smaller element is found
            }
            if (arr[i] > max) {
                max = arr[i]; // Update max if a larger element is found
            }
        }

        // Output the results
        System.out.println("Smallest Element: " + min);
        System.out.println("Largest Element: " + max);

        scanner.close();
    }
}
