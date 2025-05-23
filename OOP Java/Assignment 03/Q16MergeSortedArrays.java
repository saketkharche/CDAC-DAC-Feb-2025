import java.util.Arrays;

public class Q16MergeSortedArrays {

    public static void mergeSortedArrays(int[] A, int[] B) {
        int p = A.length;
        int q = B.length;
        int[] temp = new int[p + q];

        // Copy elements of A and B into temp array
        for (int i = 0; i < p; i++) {
            temp[i] = A[i];
        }
        for (int i = 0; i < q; i++) {
            temp[p + i] = B[i];
        }

        // Sort the temp array
        Arrays.sort(temp);

        // Fill the first p smallest elements into A
        for (int i = 0; i < p; i++) {
            A[i] = temp[i];
        }

        // Fill the remaining elements into B
        for (int i = 0; i < q; i++) {
            B[i] = temp[p + i];
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 5, 6, 7, 8, 10};
        int[] B = {2, 4, 9};

        mergeSortedArrays(A, B);

        // Display the result
        System.out.println("Sorted Array A: " + Arrays.toString(A));
        System.out.println("Sorted Array B: " + Arrays.toString(B));
    }
}
