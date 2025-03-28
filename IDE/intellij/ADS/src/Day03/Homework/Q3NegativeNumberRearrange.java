package Day03.Homework;

public class Q3NegativeNumberRearrange {
    public static void rearrangeArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Find first positive number from left
            while (left < arr.length && arr[left] < 0) {
                left++;
            }

            // Find first negative number from right
            while (right >= 0 && arr[right] >= 0) {
                right--;
            }

            // Swap if left is less than right
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
    }

    // Print array method
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        System.out.println("Original Array:");
        printArray(arr1);

        // Rearrange the array
        rearrangeArray(arr1);

        System.out.println("Rearranged Array:");
        printArray(arr1);

        int[] arr2 = {1, 2, 3, 4, 5, -1, -2, -3, -4, -5};
        System.out.println("\nOriginal Array:");
        printArray(arr2);

        // Rearrange the array
        rearrangeArray(arr2);

        System.out.println("Rearranged Array:");
        printArray(arr2);
    }
}