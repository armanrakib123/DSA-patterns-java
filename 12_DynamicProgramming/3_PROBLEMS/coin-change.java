package 26_1D_DYNAMIC_PROGRAMMING_PATTERN.TOP_10_PROBLEMS;

import java.util.Arrays;

/**
 * LeetCode 322. Coin Change
 * Category: Medium (1D DP / Unbounded Knapsack)
 */
public class coin_change {

    /**
     * Approach: Bottom-up Tabulation
     * dp[i] = min coins needed for amount i
     * dp[i] = min(dp[i], 1 + dp[i - coin]) for all coins
     * 
     * Time Complexity: O(Amount * N)
     * Space Complexity: O(Amount)
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
