package Day03;

import java.util.Scanner;

public class ArrayOperation {
    // Declare static array and size variables
    static int[] a1 = new int[100]; // Assume maximum array size of 100
    static int n = 0; // Current number of elements in the array

    // Method to display array elements
    static void display() {
        if (n == 0) {
            System.out.println("Array is empty.");
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a1[i] + " ");
        }
        System.out.println(); // New line after printing elements
    }

    // Method to insert an element into the array
    static void insert() {
        Scanner scanner = new Scanner(System.in);

        if (n >= a1.length) {
            System.out.println("Array is full. Cannot insert more elements.");
            return;
        }

        System.out.print("Enter element to insert: ");
        int element = scanner.nextInt();

        a1[n] = element;
        n++; // Increment the number of elements

        System.out.println("Element inserted successfully.");
    }

    // Method to delete an element from the array
    static void delete() {
        Scanner scanner = new Scanner(System.in);

        if (n == 0) {
            System.out.println("Array is empty. Cannot delete.");
            return;
        }

        System.out.print("Enter element to delete: ");
        int key = scanner.nextInt();

        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (a1[i] == key) {
                // Shift elements to the left to remove the found element
                for (int j = i; j < n - 1; j++) {
                    a1[j] = a1[j + 1];
                }
                n--; // Decrement the number of elements
                found = true;
                System.out.println("Element deleted successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Element not found in the array.");
        }
    }

    // Method to find an element in the array
    static boolean find(int key) {
        for (int i = 0; i < n; i++) {
            if (a1[i] == key) {
                return true;
            }
        }
        return false; // Return false if element is not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nArray Operations Menu:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Find");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    insert();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.out.print("Enter element to find: ");
                    int searchKey = scanner.nextInt();
                    if (find(searchKey)) {
                        System.out.println("Element found in the array.");
                    } else {
                        System.out.println("Element not found in the array.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}