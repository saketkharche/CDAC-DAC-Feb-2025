package Day03.Homework;

public class Q2Search {
    // Linear Search Approach
    public static int linearSearch(int[] arr, int x) {
        // Iterate through each element in the array
        for (int i = 0; i < arr.length; i++) {
            // If element found, return its index
            if (arr[i] == x) {
                return i;
            }
        }
        // If element not found, return -1
        return -1;
    }

    // Binary Search Approach (for sorted arrays)
    public static int binarySearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if x is present at mid
            if (arr[mid] == x) {
                return mid;
            }

            // If x greater, ignore left half
            if (arr[mid] < x) {
                left = mid + 1;
            }
            // If x is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

        // Element was not found
        return -1;
    }

    public static void main(String[] args) {
        // Test array
        int[] arr = {10, 20, 80, 30, 60, 50, 110, 100, 130, 170};

        // Test cases
        System.out.println("Linear Search:");
        // Search for existing element
        System.out.println("Index of 110: " + linearSearch(arr, 60));
        // Search for non-existing element
        System.out.println("Index of 175: " + linearSearch(arr, 175));

        // Note: Binary search requires a sorted array
        int[] sortedArr = {10, 20, 30, 50, 60, 80, 100, 110, 130, 170};
        System.out.println("\nBinary Search:");
        // Search in sorted array
        System.out.println("Index of 110: " + binarySearch(sortedArr, 110));
        System.out.println("Index of 175: " + binarySearch(sortedArr, 175));
    }
}