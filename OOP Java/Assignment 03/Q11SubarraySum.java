import java.util.Scanner;

public class Q11SubarraySum {

    public static void findSubarray(int[] arr, int target) {
        int sum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];

            while (sum > target) {
                sum -= arr[start];
                start++;
            }

            if (sum == target) {
                System.out.println("Subarray found from index " + start + " to " + end);
                return;
            }
        }

        System.out.println("No subarray with given sum found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array
        System.out.print("Enter size of array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();

        // Target sum
        System.out.print("Enter target sum: ");
        int target = scanner.nextInt();

        findSubarray(arr, target);

        scanner.close();
    }
}
