package 27_2D_DYNAMIC_PROGRAMMING_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 10. Regular Expression Matching
 * Category: Hard (2D DP / String Matching)
 * 
 * Problem: Support '.' and '*' matching.
 */
public class regular_expression_matching {

    /**
     * Approach: 2D Tabulation
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N)
     */
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        // Handling patterns like a*, a*b*, etc. for empty string
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                
                if (pc == sc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // 1. Zero occurrences of the character before *
                    dp[i][j] = dp[i][j - 2];
                    
                    // 2. One or more occurrences if the char before * matches
                    char prevPc = p.charAt(j - 2);
                    if (prevPc == sc || prevPc == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        
        return dp[m][n];
    }

    /*
     * FAANG Interview Note:
     * The '*' case is the hardest. It can represent 0, 1, or many 
     * of the preceding character. DP allows us to check all possibilities.
     */
}
