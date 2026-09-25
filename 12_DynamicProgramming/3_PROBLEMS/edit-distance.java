package 27_2D_DYNAMIC_PROGRAMMING_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 72. Edit Distance
 * Category: Hard (2D DP / String Matching)
 */
public class edit_distance {

    /**
     * Approach: 2D Tabulation
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N)
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        // Base cases: converting empty string to word2 or word1 to empty
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Min of Insert, Delete, Replace
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], 
                                   Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        
        return dp[m][n];
    }
}
