package Day10;

public class QuickSortDemo {

   // Main QuickSort function
   static void quickSort(int[] arr, int low, int high) {
      if (low < high) {
         // Partition the array and get the pivot index
         int pi = partition(arr, low, high);
      
         System.out.println("After partitioning, pivot (" + arr[pi] + ") is placed at index " + pi);
         display(arr); // Display the array after partitioning
      
         // Recursively sort elements before and after partition
         quickSort(arr, low, pi - 1); // Sort left side of the pivot
         quickSort(arr, pi + 1, high); // Sort right side of the pivot
      }
   }

   // Partition function: Rearranges the array and returns the pivot index
   static int partition(int[] arr, int low, int high) {
      int pivot = arr[high]; // Choose the last element as the pivot
      int i = low - 1; // Index of the smaller element
   
      System.out.println("\nPartitioning array from index " + low + " to " + high);
      System.out.println("Pivot value: " + pivot + " (initially at index " + high + ")");
   
      for (int j = low; j < high; j++) {
         // If the current element is smaller than or equal to the pivot
         if (arr[j] <= pivot) {
            i++; // Increment the index of the smaller element
            swap(arr, i, j); // Swap arr[i] and arr[j]
            System.out.println("Swapped elements at indices " + i + " and " + j);
         }
      }
   
      // Place the pivot in its correct position
      swap(arr, i + 1, high);
      System.out.println("Placed pivot (" + pivot + ") at index " + (i + 1));
   
      return (i + 1); // Return the partition index
   }

   // Swap two elements in the array
   static void swap(int[] arr, int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }

   // Display the array
   static void display(int arr[]) {
      for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.println(); // Add a newline for better formatting
   }

   // Main method to test QuickSort
   public static void main(String[] args) {
      int arr[] = {99, 44, 77, 22, 88, 33, 11, 66, 55};
   
      System.out.println("Original Array:");
      display(arr); // Display the original array
      System.out.println();
   
      // Perform QuickSort
      quickSort(arr, 0, arr.length - 1);
   
      System.out.println("\nSorted Array:");
      display(arr); // Display the sorted array
   }
}