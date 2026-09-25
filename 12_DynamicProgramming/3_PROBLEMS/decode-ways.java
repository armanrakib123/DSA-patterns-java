package 26_1D_DYNAMIC_PROGRAMMING_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 91. Decode Ways
 * Category: Medium (1D DP)
 */
public class decode_ways {

    /**
     * Approach: Iterative DP
     * Similar to climbing stairs but with conditions (valid digits).
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1) optimized
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        
        int n = s.length();
        int prev2 = 1; // dp[i-2]
        int prev1 = 1; // dp[i-1]
        
        for (int i = 2; i <= n; i++) {
            int curr = 0;
            int first = Integer.parseInt(s.substring(i-1, i));
            int second = Integer.parseInt(s.substring(i-2, i));
            
            if (first >= 1 && first <= 9) curr += prev1;
            if (second >= 10 && second <= 26) curr += prev2;
            
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
}
