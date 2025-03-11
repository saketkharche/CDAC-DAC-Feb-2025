import java.util.Arrays;

public class Q8MergeSortedArrays {

    // Function to merge two sorted arrays without extra space
    public static void merge(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int gap = (n + m + 1) / 2; // Initial gap

        while (gap > 0) {
            int i = 0, j = gap;

            while (j < (n + m)) {
                if (j < n) { // Both elements in arr1
                    if (arr1[i] > arr1[j]) {
                        // Swap if elements are out of order
                        int temp = arr1[i];
                        arr1[i] = arr1[j];
                        arr1[j] = temp;
                    }
                } else if (i < n) { // One element in arr1 and the other in arr2
                    if (arr1[i] > arr2[j - n]) {
                        int temp = arr1[i];
                        arr1[i] = arr2[j - n];
                        arr2[j - n] = temp;
                    }
                } else { // Both elements in arr2
                    if (arr2[i - n] > arr2[j - n]) {
                        int temp = arr2[i - n];
                        arr2[i - n] = arr2[j - n];
                        arr2[j - n] = temp;
                    }
                }
                i++;
                j++;
            }

            if (gap == 1)
                break;
            gap = (gap + 1) / 2; // Reduce the gap
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 5, 9 };
        int[] arr2 = { 2, 3, 6, 7 };

        System.out.println("Before Merging:");
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));

        merge(arr1, arr2);

        System.out.println("\nAfter Merging:");
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));
    }
}
