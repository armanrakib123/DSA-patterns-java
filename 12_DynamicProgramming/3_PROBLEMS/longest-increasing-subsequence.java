package 26_1D_DYNAMIC_PROGRAMMING_PATTERN.TOP_10_PROBLEMS;

import java.util.Arrays;

/**
 * LeetCode 300. Longest Increasing Subsequence
 * Category: Medium (1D DP)
 */
public class longest_increasing_subsequence {

    /**
     * Approach: DP
     * dp[i] = length of LIS ending at index i
     * 
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        return maxLen;
    }

    /*
     * FAANG Interview Note:
     * While O(N^2) is the common DP solution, there is an O(N log N) solution 
     * using Binary Search which is often asked as a follow-up.
     */
}
