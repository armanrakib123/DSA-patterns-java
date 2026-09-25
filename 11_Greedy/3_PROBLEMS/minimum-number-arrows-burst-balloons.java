package 24_GREEDY_PATTERN.TOP_10_PROBLEMS;

import java.util.Arrays;

/**
 * LeetCode 452. Minimum Number of Arrows to Burst Balloons
 * Category: Medium (Interval Greedy)
 */
public class minimum_number_arrows_burst_balloons {

    /**
     * Approach: Sort by end time
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(1)
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        
        // Use Integer.compare to avoid overflow during subtraction
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrows = 1;
        int end = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            // If the next balloon starts after current arrow's reach
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }
        
        return arrows;
    }
}
