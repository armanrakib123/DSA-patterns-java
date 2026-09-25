package 27_2D_DYNAMIC_PROGRAMMING_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 1143. Longest Common Subsequence
 * Category: Medium (2D DP / String Matching)
 */
public class longest_common_subsequence {

    /**
     * Approach: 2D Tabulation
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N)
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[m][n];
    }

    /*
     * FAANG Interview Note:
     * This is the foundation of many string comparison problems. 
     * Practice space optimization using two rows only.
     */
}
