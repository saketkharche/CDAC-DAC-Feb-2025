import java.util.Arrays;

public class q17MaximumProductPair {
    public static void main(String[] args) {
        // Example input array
        int[] nums = {2, 3, 5, 7, -7, 5, 8, -5};
        
        // Find maximum product pair
        findMaxProductPair(nums);
    }
    
    public static void findMaxProductPair(int[] nums) {
        if (nums == null || nums.length < 2) {
            System.out.println("Array should have at least two elements");
            return;
        }
        
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        int maxI = 0, maxJ = 0;
        
        // Approach 1: Brute force method - checking all possible pairs
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                if (product > maxProduct) {
                    maxProduct = product;
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        
        System.out.println("Pair is (" + nums[maxI] + ", " + nums[maxJ] + "), Maximum Product: " + maxProduct);
        
        // Alternative approach: Sort the array and check specific pairs
        // This would be more efficient for larger arrays
        System.out.println("\nAlternative solution using sorting:");
        findMaxProductPairUsingSorting(nums.clone());
    }
    
    public static void findMaxProductPairUsingSorting(int[] nums) {
        int n = nums.length;
        
        // Sort the array
        Arrays.sort(nums);
        
        // The maximum product could be either:
        // 1. Product of the two largest numbers (if both are positive or both are negative)
        // 2. Product of the two smallest numbers (if both are negative)
        int product1 = nums[n-1] * nums[n-2]; // Two largest numbers
        int product2 = nums[0] * nums[1];     // Two smallest numbers
        
        if (product1 > product2) {
            System.out.println("Pair is (" + nums[n-2] + ", " + nums[n-1] + "), Maximum Product: " + product1);
        } else {
            System.out.println("Pair is (" + nums[0] + ", " + nums[1] + "), Maximum Product: " + product2);
        }
    }
}