package 26_1D_DYNAMIC_PROGRAMMING_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 746. Min Cost Climbing Stairs
 * Category: Easy (1D DP)
 */
public class min_cost_climbing_stairs {

    /**
     * Approach: Bottom-up Tabulation
     * dp[i] = cost[i] + min(dp[i-1], dp[i-2])
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1) optimized
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev2 = cost[0];
        int prev1 = cost[1];
        
        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return Math.min(prev1, prev2);
    }
}
