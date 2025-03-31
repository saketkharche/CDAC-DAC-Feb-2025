package Assignment01;

public class Q3ArraySearchAndPeak {
    public static void main(String[] args) {
        int[] arr = {1, 3, 3, 3, 5, 6, 8};
        int key = 3;

        int index = binarySearch(arr, key);
        System.out.println("Key found at index: " + index);

        int firstOccurrence = findFirstOccurrence(arr, key);
        int lastOccurrence = findLastOccurrence(arr, key);
        System.out.println("First occurrence: " + firstOccurrence);
        System.out.println("Last occurrence: " + lastOccurrence);
        System.out.println("Total count of key: " + (lastOccurrence - firstOccurrence + 1));

        int[] peakArr = {1, 2, 18, 4, 5, 0};
        int peakElement = findPeakElement(peakArr);
        System.out.println("Peak element: " + peakElement);
    }

    // Binary search function
    public static int binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Find first occurrence of key
    public static int findFirstOccurrence(int[] arr, int key) {
        int left = 0, right = arr.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    // Find last occurrence of key
    public static int findLastOccurrence(int[] arr, int key) {
        int left = 0, right = arr.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    // Find any peak element in the array
    public static int findPeakElement(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];
        if (arr[0] > arr[1]) return arr[0];
        if (arr[n - 1] > arr[n - 2]) return arr[n - 1];

        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return arr[i];
            }
        }
        return -1; // No peak found (shouldn't happen with valid input)
    }
}
