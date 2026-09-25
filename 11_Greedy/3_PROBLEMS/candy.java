package 24_GREEDY_PATTERN.TOP_10_PROBLEMS;

import java.util.Arrays;

/**
 * LeetCode 135. Candy
 * Category: Hard (Greedy / Two-pass)
 * 
 * Problem: Each child must have at least one candy. Children with a higher rating 
 * get more candies than their neighbors. Return the minimum candies you must give.
 */
public class candy {

    /**
     * Approach: Two-pass Greedy
     * 1. Left to right: satisfy right neighbor condition.
     * 2. Right to left: satisfy left neighbor condition.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        
        // Left to Right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }
        
        // Right to Left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }
        
        int total = 0;
        for (int c : candies) total += c;
        return total;
    }

    /*
     * FAANG Interview Note:
     * This is a beautiful greedy problem. The "Two-pass" strategy is a 
     * common pattern when a node's state depends on both its neighbors.
     */
}
