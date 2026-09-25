package 26_1D_DYNAMIC_PROGRAMMING_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 53. Maximum Subarray (Kadane's Algorithm)
 * Category: Medium (Greedy / DP)
 */
public class maximum_subarray {

    /**
     * Approach: DP (Kadane's)
     * At each index, decide whether to start a new subarray or continue the previous one.
     * currentMax = max(nums[i], currentMax + nums[i])
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int globalMax = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            globalMax = Math.max(globalMax, currentMax);
        }
        
        return globalMax;
    }

    /*
     * FAANG Interview Note:
     * This is a special case of DP where you only need the immediate previous state.
     */
}
