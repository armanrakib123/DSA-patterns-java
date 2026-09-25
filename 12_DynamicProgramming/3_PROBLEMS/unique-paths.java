package 27_2D_DYNAMIC_PROGRAMMING_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 62. Unique Paths
 * Category: Medium (2D DP / Grid)
 */
public class unique_paths {

    /**
     * Approach: 2D Tabulation
     * dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(N) optimized
     */
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        java.util.Arrays.fill(dp, 1);
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        
        return dp[n - 1];
    }
}
