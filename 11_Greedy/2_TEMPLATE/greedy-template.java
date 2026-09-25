package 24_GREEDY_PATTERN.TEMPLATE;

import java.util.*;

/**
 * FAANG Standard Greedy Algorithm Templates
 */
public class greedy_template {

    /**
     * Template 1: Interval Scheduling (Max non-overlapping)
     * Sort by End Time
     */
    public int maxIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        // 1. Sort by end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 1;
        int end = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            // 2. If next interval starts after or at current end
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1]; // Update current end
            }
        }
        return count;
    }

    /**
     * Template 2: Greedy Choice with Sorting
     * Common for problems like Assign Cookies, Lemonade Change.
     */
    public void greedyWithSort(int[] items) {
        Arrays.sort(items);
        for (int item : items) {
            // Take the best possible decision for current item
        }
    }

    /**
     * Template 3: One-pass Greedy (Max Reach)
     * Common for Jump Game, Gas Station.
     */
    public boolean canReachEnd(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false; // Cannot even reach current index
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }
}
