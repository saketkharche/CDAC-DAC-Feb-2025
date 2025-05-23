package Day03.Homework;

public class Q1DuplicatesArr {
    public static int[] findDuplicates(int[] arr) {
        // Create a new array to mark duplicates
        int[] result = new int[arr.length];
        int index = 0;

        // Nested loops to find duplicates
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                // If duplicate found and not already added to result
                if (arr[i] == arr[j] && !contains(result, arr[i])) {
                    result[index++] = arr[i];
                }
            }
        }

        // Return duplicates or [-1] if no duplicates
        return index == 0 ? new int[]{-1} : java.util.Arrays.copyOf(result, index);
    }

    // Helper method to check if array contains a value
    private static boolean contains(int[] arr, int value) {
        for (int num : arr) {
            if (num == value) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {0, 1, 2, 3}; // No duplicates
        System.out.println("No duplicates: " + java.util.Arrays.toString(findDuplicates(arr1)));

        int[] arr2 = {0, 3, 1, 2, 2, 3}; // With duplicates
        System.out.println("With duplicates: " + java.util.Arrays.toString(findDuplicates(arr2)));
    }
}