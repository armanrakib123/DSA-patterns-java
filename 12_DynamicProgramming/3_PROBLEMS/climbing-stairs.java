package 

26_1D_DYNAMIC_PROGRAMMING_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 70. Climbing Stairs
 * Category: Easy (1D DP)
 * 
 * Problem: You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class climbing_stairs {

    /**
     * Approach: Bottom-up DP (Fibonacci logic) To reach step i, you can come
     * from step i-1 or i-2. dp[i] = dp[i-1] + dp[i-2]
     *
     * Time Complexity: O(N) Space Complexity: O(1) optimized
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int first = 1;
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }

    /*
     * Software Company Interview Note:
     * This is the absolute starting point for DP. 
     * Always remember to mention the space optimization from O(N) to O(1).
     */
}
