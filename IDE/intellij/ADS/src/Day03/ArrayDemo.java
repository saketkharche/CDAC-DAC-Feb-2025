package Day03;

class ArrayDemo {
    // Static array of size 15
    static int a1[] = new int[15];
    // Counter to track number of elements
    static int n = 0;

    // Method to display array elements
    static void display() {
        for(int i = 0; i < n; i++) {
            System.out.print(a1[i] + " ");
        }
    }

    // Method to insert elements
    static void insert(int value) {
        if(n < a1.length) {
            a1[n] = value;  // Add element at the end
            n++;  // Increment element count
        } else {
            System.out.print("Array is full!");
        }
    }

    // Method to find an element
    static boolean find(int key) {
        for(int i = 0; i < n; i++) {
            if(a1[i] == key) {
                return true;  // Element found
            }
        }
        return false;  // Element not found
    }

    // Method to delete an element
    static void delete(int key) {
        int i;
        // Find the index of the element
        for(i = 0; i < n; i++) {
            if(a1[i] == key) {
                break;  // Found: exit the loop
            }
        }

        // If element does not exist
        if(i == n) {
            System.out.println("Element does not exist!");
            return;
        }

        // Shift elements to cover the deleted element
        for(int k = i; k < n - 1; k++) {
            a1[k] = a1[k+1];
        }
        n--;  // Decrease element count
    }

    public static void main(String[] args) {
        // Initial display (empty array)
        display();
        System.out.println("\n---------------------------");

        // Insert elements
        insert(10);
        insert(20);
        insert(30);
        insert(40);
        insert(50);

        System.out.println("\n---------------------------");

        // Display inserted elements
        display();

        System.out.println("\n---------------------------");

        // Delete an element
        int key = 20;
        delete(key);

        // Display after deletion
        display();
    }
}