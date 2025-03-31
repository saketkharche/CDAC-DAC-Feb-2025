package Assignment01;
public class Q1ArrayOperation {
    public static void main(String[] args) {
        int[] arr = {10, 0, 5, 20, 0, 8, 15};

        int secondLargest = findSecondLargest(arr);
        System.out.println("Second largest element: " + secondLargest);

        moveZerosToEnd(arr);
        System.out.print("Array after moving zeros: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // Function to find the second largest element in the array
    public static int findSecondLargest(int[] arr) {
        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax && num < firstMax) {
                secondMax = num;
            }
        }
        return secondMax;
    }

    // Function to move all zeros to the end while maintaining the order of non-zero elements
    public static void moveZerosToEnd(int[] arr) {
        int nonZeroIndex = 0;

        // Move non-zero elements forward
        for (int num : arr) {
            if (num != 0) {
                arr[nonZeroIndex++] = num;
            }
        }

        // Fill remaining positions with zeros
        while (nonZeroIndex < arr.length) {
            arr[nonZeroIndex++] = 0;
        }
    }
}
