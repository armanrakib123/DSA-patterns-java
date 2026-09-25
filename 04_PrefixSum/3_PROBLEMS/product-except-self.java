package 03_PREFIX_SUM_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 238. Product of Array Except Self
 * Category: Medium (FAANG Favorite - Amazon, Apple, Facebook)
 * 
 * Problem: Given an integer array nums, return an array answer such that answer[i] 
 * is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
public class product_except_self {

    /**
     * Approach: Prefix and Suffix Products (Space Optimized)
     * Instead of using sum, we use multiplication. We can think of it as Prefix Product.
     * answer[i] = (Product of elements to the left) * (Product of elements to the right)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1) (excluding output array)
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Step 1: Calculate Left Prefix Products
        // result[i] will contain the product of all elements to the left of i
        result[0] = 1; // Left of 0th element is nothing, so product is 1
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        // Step 2: Calculate Right Suffix Products on the fly and multiply with left products
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            // Multiply the current prefix product with the suffix product
            result[i] = result[i] * rightProduct;
            // Update suffix product for the next element
            rightProduct *= nums[i];
        }
        
        return result;
    }

    /*
     * FAANG Interview Note:
     * This is a classic. If you use division, you fail immediately.
     * The initial thought might be creating a prefix[] and suffix[] array taking O(N) extra space.
     * The true FAANG level solution optimizes the space to O(1) by reusing the result array 
     * for prefix products and calculating suffix products dynamically on the fly.
     */
}
