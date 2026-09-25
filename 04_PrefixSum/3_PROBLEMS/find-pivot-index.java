package 03_PREFIX_SUM_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 1991. Find the Middle Index in Array 
 * (Exact same logic as LeetCode 724. Find Pivot Index)
 * Category: Easy
 * 
 * Problem: Given a 0-indexed integer array nums, find the leftmost middleIndex.
 * A middleIndex is an index where the sum of numbers to the left equals the sum of numbers to the right.
 */
public class find_pivot_index {

    /**
     * Approach: Total Sum Optimization (Space O(1))
     * This is provided as an alternative template to pivot-index.java to demonstrate 
     * how multiple LeetCode problems share the EXACT same pattern.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int findMiddleIndex(int[] nums) {
        // Step 1: Get the total sum
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int leftSum = 0;
        
        // Step 2: Iterate and dynamically calculate rightSum
        for (int i = 0; i < nums.length; i++) {
            // rightSum = totalSum - leftSum - current element
            int rightSum = totalSum - leftSum - nums[i];
            
            if (leftSum == rightSum) {
                return i;
            }
            
            // Add to left sum for next iteration
            leftSum += nums[i];
        }
        
        return -1;
    }
}
