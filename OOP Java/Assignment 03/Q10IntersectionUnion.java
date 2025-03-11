import java.util.HashSet;
import java.util.Scanner;

public class Q10IntersectionUnion {

    // Function to find union of two arrays
    public static void findUnion(int[] arr1, int[] arr2) {
        HashSet<Integer> union = new HashSet<>();

        for (int num : arr1) union.add(num);
        for (int num : arr2) union.add(num);

        System.out.print("Union: ");
        for (int num : union) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Function to find intersection of two arrays
    public static void findIntersection(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        System.out.print("Intersection: ");
        for (int num : arr1) set.add(num);

        for (int num : arr2) {
            if (set.contains(num)) {
                System.out.print(num + " ");
                set.remove(num);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input first array
        System.out.print("Enter size of first array: ");
        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter elements of first array:");
        for (int i = 0; i < n1; i++) arr1[i] = scanner.nextInt();

        // Input second array
        System.out.print("Enter size of second array: ");
        int n2 = scanner.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Enter elements of second array:");
        for (int i = 0; i < n2; i++) arr2[i] = scanner.nextInt();

        // Find union and intersection
        findUnion(arr1, arr2);
        findIntersection(arr1, arr2);

        scanner.close();
    }
}
