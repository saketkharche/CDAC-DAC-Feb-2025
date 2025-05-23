package Day03;

import java.util.Scanner; // 📥 Import Scanner to take input

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1; // 📌 Start and end points

        while (left <= right) { // 🔄 Keep searching until left crosses right
            int mid = left + (right - left) / 2; // 📏 Find middle index

            if (arr[mid] == target) { // 🎯 If found, return index
                return mid;
            } else if (arr[mid] < target) { // 🔼 If target is bigger, search right side
                left = mid + 1;
            } else { // 🔽 If target is smaller, search left side
                right = mid - 1;
            }
        }
        return -1; // ❌ If not found, return -1
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 🛠️ Scanner object

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt(); // 📥 Get array size

        int[] numbers = new int[n]; // 📦 Create array
        System.out.println("Enter " + n + " sorted numbers:");
        for (int i = 0; i < n; i++) { // 📥 Take user input
            numbers[i] = scanner.nextInt();
        }

        System.out.print("Enter the number to search: ");
        int target = scanner.nextInt(); // 🎯 Get the number to search

        int index = binarySearch(numbers, target); // 🔍 Call function

        if (index != -1) {
            System.out.println("Number " + target + " found at index " + index);
        } else {
            System.out.println("Number " + target + " not found!");
        }

        scanner.close(); // 🚪 Close Scanner
    }
}
