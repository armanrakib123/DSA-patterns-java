package 

26_1D_DYNAMIC_PROGRAMMING_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 198. House Robber
 * Category: Medium (1D DP)
 * 
 * Problem: You are a professional robber. You cannot rob two adjacent houses. 
 * Find the maximum amount of money you can rob tonight.
 */
public class house_robber {

    /**
     * Approach: DP (Include or Exclude current house) dp[i] = max(rob house i +
     * dp[i-2], don't rob house i (so dp[i-1]))
     *
     * Time Complexity: O(N) Space Complexity: O(1) optimized
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int prev2 = 0;
        int prev1 = 0;

        for (int num : nums) {
            int curr = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    /*
     * Software Company Interview Note:
     * This "Pick or Skip" logic is the foundation for almost all 
     * optimization-based DP problems.
     */
}
