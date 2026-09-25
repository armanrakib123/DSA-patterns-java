package 26_1D_DYNAMIC_PROGRAMMING_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 139. Word Break
 * Category: Medium (1D DP)
 */
public class word_break {

    /**
     * Approach: Bottom-up DP
     * dp[i] is true if s[0...i-1] can be segmented into words.
     * 
     * Time Complexity: O(N^3) (substring operation takes O(N))
     * Space Complexity: O(N)
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}
