package 24_GREEDY_PATTERN.TOP_10_PROBLEMS;

import java.util.Arrays;

/**
 * LeetCode 435. Non-overlapping Intervals
 * Category: Medium (Interval Greedy)
 */
public class non_overlapping_intervals {

    /**
     * Approach: Sort by end time and count overlaps
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(1)
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int nonOverlappingCount = 1;
        int end = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                nonOverlappingCount++;
                end = intervals[i][1];
            }
        }
        
        return intervals.length - nonOverlappingCount;
    }
}
