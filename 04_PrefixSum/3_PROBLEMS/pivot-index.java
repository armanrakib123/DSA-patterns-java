package 03_PREFIX_SUM_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 724. Find Pivot Index
 * Category: Easy
 * 
 * Problem: Given an array of integers nums, calculate the pivot index of this array.
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index 
 * is equal to the sum of all the numbers strictly to the index's right.
 * Return the leftmost pivot index. If no such index exists, return -1.
 */
public class pivot_index {

    /**
     * Approach: Total Sum and Running Prefix Sum
     * Instead of creating a new array for Prefix Sum, we first calculate the total sum.
     * Then we iterate through the array maintaining a leftSum.
     * Right sum can be dynamically calculated as: totalSum - leftSum - nums[i].
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1) (Highly Optimized)
     */
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // rightSum is totalSum - leftSum - current element
            int rightSum = totalSum - leftSum - nums[i];
            
            if (leftSum == rightSum) {
                return i; // Found the leftmost pivot index
            }
            
            // Add current element to leftSum for the next iteration
            leftSum += nums[i];
        }
        
        return -1; // No pivot index found
    }

    /*
     * FAANG Interview Note:
     * This teaches Space Optimization. An amateur would create prefix[] and suffix[] arrays taking O(N) space.
     * A pro immediately notices that Right Sum = Total Sum - Left Sum - Current Element, requiring only O(1) space.
     */
}
