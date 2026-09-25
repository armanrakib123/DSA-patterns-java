package 08_BINARY_SEARCH_ON_ANSWER_PATTERN.TOP_10_PROBLEMS;

import java.util.Arrays;

/**
 * LeetCode 1552. Magnetic Force Between Two Balls
 * Category: Medium
 * 
 * Problem: In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls 
 * if they are put in his new invented basket. Rick has n empty baskets, the ith basket is at position[i], 
 * Morty has m balls and needs to distribute the balls into the baskets such that the minimum magnetic force 
 * between any two balls is maximum.
 * Return the required guaranteed maximum magnetic force.
 */
public class magnetic_force {

    /**
     * Approach: Binary Search on Answer
     * This is EXACTLY the same problem as "Aggressive Cows".
     * Replace "baskets" with "stalls", and "balls" with "cows".
     * Magnetic force = Distance between two items.
     * We want to Maximize the Minimum distance.
     * 
     * Time Complexity: O(N log(Max - Min) + N log N)
     * Space Complexity: O(1)
     */
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        
        int low = 1; 
        int high = position[position.length - 1] - position[0];
        int ans = 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canPlaceBalls(position, m, mid)) {
                ans = mid; // Try to maximize the force
                low = mid + 1;
            } else {
                high = mid - 1; // Force is too high, balls can't be placed
            }
        }
        
        return ans;
    }
    
    private boolean canPlaceBalls(int[] position, int balls, int force) {
        int ballsPlaced = 1;
        int lastPlacedPosition = position[0];
        
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPlacedPosition >= force) {
                ballsPlaced++;
                lastPlacedPosition = position[i];
            }
            
            if (ballsPlaced == balls) {
                return true;
            }
        }
        
        return false;
    }

    /*
     * FAANG Interview Note:
     * LeetCode literally copy-pasted the "Aggressive Cows" problem and changed the theme to Rick & Morty.
     * Understanding this demonstrates that you are learning PATTERNS, not memorizing specific problems.
     */
}
