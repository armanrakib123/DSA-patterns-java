package 08_BINARY_SEARCH_ON_ANSWER_PATTERN.TOP_10_PROBLEMS;

import java.util.Arrays;

/**
 * Spoj: Aggressive Cows / LeetCode 1552: Magnetic Force Between Two Balls
 * Category: Medium/Hard (The benchmark problem for "Maximize the Minimum")
 * 
 * Problem: Farmer John has built a new long barn, with N stalls. The stalls are located along 
 * a straight line at positions x1,...,xN. His C cows don't like this barn layout and become 
 * aggressive towards each other once put into a stall. To prevent the cows from hurting each other, 
 * FJ wants to assign the cows to the stalls, such that the minimum distance between any two of them 
 * is as large as possible. What is the largest minimum distance?
 */
public class aggressive_cows {

    /**
     * Approach: Binary Search on Answer (Maximize the Minimum)
     * Pattern: T T T F F F (We want the last True)
     * The minimum possible distance is 1.
     * The maximum possible distance is (Max Stall Position - Min Stall Position).
     * 
     * Time Complexity: O(N log(Max - Min) + N log N) (N log N for sorting)
     * Space Complexity: O(1) or O(log N) depending on the sorting algorithm
     */
    public int maxDistance(int[] position, int m) {
        // Essential: Stalls MUST be sorted to place cows linearly
        Arrays.sort(position);
        
        int low = 1; // Minimum possible distance
        int high = position[position.length - 1] - position[0]; // Maximum spread
        int ans = 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canPlaceCows(position, m, mid)) {
                ans = mid; // Possible! But we want to MAXIMIZE distance, so try larger
                low = mid + 1; 
            } else {
                high = mid - 1; // Not possible. Distance is too big.
            }
        }
        
        return ans;
    }
    
    /**
     * Helper: Checks if we can place 'm' cows such that every cow is at least 'distance' apart.
     */
    private boolean canPlaceCows(int[] position, int cows, int distance) {
        int cowsPlaced = 1; // We always place the first cow in the first stall
        int lastPlacedPosition = position[0];
        
        for (int i = 1; i < position.length; i++) {
            // If the distance from the last placed cow is >= required distance
            if (position[i] - lastPlacedPosition >= distance) {
                cowsPlaced++;
                lastPlacedPosition = position[i];
            }
            
            // Early exit
            if (cowsPlaced == cows) {
                return true;
            }
        }
        
        return false;
    }

    /*
     * FAANG Interview Note:
     * This is the grandfather of all "Maximize the Minimum" problems.
     * If you forget `Arrays.sort(position)`, the logic entirely collapses.
     * Always remember: You can't linearly place cows if the stalls are jumping back and forth.
     */
}
