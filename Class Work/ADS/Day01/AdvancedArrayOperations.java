package Day01;

import java.util.*;

public class AdvancedArrayOperations {
    private int[] array; // Array to store elements
    private int size; // Number of elements in the array

    public AdvancedArrayOperations(int capacity) {
        array = new int[capacity]; // Initialize array with given capacity
        size = 0;
    }

    // Insert element at the end, dynamically resizes if full
    public void insertElement(int element) {
        if (size == array.length) {
            resizeArray(size * 2); // Double the size if array is full
        }
        array[size++] = element; // Add element and increase size
    }

    // Display the array elements
    public void displayArray() {
        System.out.println(Arrays.toString(Arrays.copyOf(array, size))); // Print only valid elements
    }

    // Sort array in ascending order using Merge Sort (internally handled by Arrays.sort)
    public void sortAscending() {
        Arrays.sort(array, 0, size);
    }

    // Sort array in descending order by sorting in ascending and reversing
    public void sortDescending() {
        Arrays.sort(array, 0, size);
        reverseArray(); // Call reverse function
    }

    // Reverse the array using two-pointer technique
    public void reverseArray() {
        for (int i = 0; i < size / 2; i++) {
            int temp = array[i];
            array[i] = array[size - 1 - i];
            array[size - 1 - i] = temp;
        }
    }

    // Delete an element by value using linear search
    public void deleteByValue(int value) {
        int index = findElement(value);
        if (index != -1) deleteByIndex(index);
    }

    // Delete an element by index using array shifting
    public void deleteByIndex(int index) {
        if (index < 0 || index >= size) return;
        System.arraycopy(array, index + 1, array, index, size - index - 1); // Shift elements left
        size--;
    }

    // Replace an element at a given index
    public void replaceElement(int index, int newValue) {
        if (index >= 0 && index < size) {
            array[index] = newValue;
        }
    }

    // Find an element using linear search
    public int findElement(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) return i;
        }
        return -1;
    }

    // Find maximum element using stream max()
    public int findMax() {
        return Arrays.stream(array, 0, size).max().orElse(Integer.MIN_VALUE);
    }

    // Find minimum element using stream min()
    public int findMin() {
        return Arrays.stream(array, 0, size).min().orElse(Integer.MAX_VALUE);
    }

    // Find sum using stream sum()
    public int findSum() {
        return Arrays.stream(array, 0, size).sum();
    }

    // Find average using sum / size
    public double findAverage() {
        return size == 0 ? 0 : (double) findSum() / size;
    }

    // Find median after sorting
    public double findMedian() {
        if (size == 0) return 0;
        sortAscending();
        if (size % 2 == 1) return array[size / 2];
        return (array[size / 2 - 1] + array[size / 2]) / 2.0;
    }

    // Find mode using HashMap to count frequency
    public int findMode() {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < size; i++) {
            frequency.put(array[i], frequency.getOrDefault(array[i], 0) + 1);
        }
        return Collections.max(frequency.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    // Remove duplicates using LinkedHashSet
    public void removeDuplicates() {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < size; i++) set.add(array[i]);
        size = 0;
        for (int num : set) array[size++] = num;
    }

    // Resize array dynamically using Arrays.copyOf
    public void resizeArray(int newSize) {
        array = Arrays.copyOf(array, newSize);
    }

    // Count occurrences using stream filter
    public int countOccurrences(int value) {
        return (int) Arrays.stream(array, 0, size).filter(x -> x == value).count();
    }

    // Find maximum subarray sum using Kadane's algorithm
    public int findMaxSubarraySum() {
        int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0;
        for (int i = 0; i < size; i++) {
            maxEndingHere = Math.max(array[i], maxEndingHere + array[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initial array capacity: ");
        int capacity = scanner.nextInt();
        AdvancedArrayOperations arrayOps = new AdvancedArrayOperations(capacity);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert Element");
            System.out.println("2. Display Array");
            System.out.println("3. Sort Ascending");
            System.out.println("4. Sort Descending");
            System.out.println("5. Delete by Value");
            System.out.println("6. Delete by Index");
            System.out.println("7. Replace Element");
            System.out.println("8. Find Element");
            System.out.println("9. Find Max & Min");
            System.out.println("10. Find Sum & Average");
            System.out.println("11. Find Median");
            System.out.println("12. Find Mode");
            System.out.println("13. Reverse Array");
            System.out.println("14. Remove Duplicates");
            System.out.println("15. Count Occurrences");
            System.out.println("16. Find Max Subarray Sum");
            System.out.println("17. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> { System.out.print("Enter element: "); arrayOps.insertElement(scanner.nextInt()); }
                case 2 -> arrayOps.displayArray();
                case 3 -> arrayOps.sortAscending();
                case 4 -> arrayOps.sortDescending();
                case 5 -> { System.out.print("Enter value: "); arrayOps.deleteByValue(scanner.nextInt()); }
                case 6 -> { System.out.print("Enter index: "); arrayOps.deleteByIndex(scanner.nextInt()); }
                case 7 -> { System.out.print("Enter index and value: "); arrayOps.replaceElement(scanner.nextInt(), scanner.nextInt()); }
                case 8 -> { System.out.print("Enter value: "); System.out.println("Index: " + arrayOps.findElement(scanner.nextInt())); }
                case 9 -> System.out.println("Max: " + arrayOps.findMax() + ", Min: " + arrayOps.findMin());
                case 10 -> System.out.println("Sum: " + arrayOps.findSum() + ", Average: " + arrayOps.findAverage());
                case 11 -> System.out.println("Median: " + arrayOps.findMedian());
                case 12 -> System.out.println("Mode: " + arrayOps.findMode());
                case 13 -> arrayOps.reverseArray();
                case 14 -> arrayOps.removeDuplicates();
                case 15 -> { System.out.print("Enter value: "); System.out.println("Occurrences: " + arrayOps.countOccurrences(scanner.nextInt())); }
                case 16 -> System.out.println("Max Subarray Sum: " + arrayOps.findMaxSubarraySum());
                case 17 -> { scanner.close(); return; }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}
