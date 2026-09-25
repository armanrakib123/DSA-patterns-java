package 

26_1D_DYNAMIC_PROGRAMMING_PATTERN.TEMPLATE;

import java.util.*;

/**
 * Software Company Standard 1D Dynamic Programming Templates
 */
public class dp_1d_template {

    /**
     * Template 1: Top-Down (Memoization)
     */
    public int solveMemo(int n, Integer[] memo) {
        // 1. Base case
        if (n <= 1) {
            return n;
        }

        // 2. Check cache
        if (memo[n] != null) {
            return memo[n];
        }

        // 3. Compute and store
        return memo[n] = solveMemo(n - 1, memo) + solveMemo(n - 2, memo);
    }

    /**
     * Template 2: Bottom-Up (Tabulation)
     */
    public int solveTab(int n) {
        if (n <= 1) {
            return n;
        }

        // 1. Initialize table
        int[] dp = new int[n + 1];

        // 2. Base cases
        dp[0] = 0;
        dp[1] = 1;

        // 3. Fill table iteratively
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /**
     * Template 3: Space Optimized DP When dp[i] only depends on dp[i-1] and
     * dp[i-2]
     */
    public int solveOptimized(int n) {
        if (n <= 1) {
            return n;
        }

        int prev2 = 0; // dp[i-2]
        int prev1 = 1; // dp[i-1]

        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
