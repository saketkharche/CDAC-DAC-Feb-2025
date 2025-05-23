import java.util.ArrayList;

public class Q15SubarraysWithZeroSum {

    public static void findZeroSumSubarrays(int[] arr) {
        int n = arr.length;
        boolean found = false;

        // Generate all subarrays
        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += arr[end];

                // If sum becomes zero, print the subarray
                if (sum == 0) {
                    found = true;
                    System.out.print("Subarray with 0 sum: [");
                    for (int k = start; k <= end; k++) {
                        System.out.print(arr[k]);
                        if (k < end) System.out.print(", ");
                    }
                    System.out.println("]");
                }
            }
        }

        if (!found) {
            System.out.println("No subarray with zero sum found.");
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, -7, 3, 2, 3, 1, -3, -2, -2};
        int[] nums2 = {1, 2, -3, 4, 5, 6};
        int[] nums3 = {1, 2, -2, 3, 4, 5, 6};

        System.out.println("For nums1:");
        findZeroSumSubarrays(nums1);

        System.out.println("\nFor nums2:");
        findZeroSumSubarrays(nums2);

        System.out.println("\nFor nums3:");
        findZeroSumSubarrays(nums3);
    }
}
