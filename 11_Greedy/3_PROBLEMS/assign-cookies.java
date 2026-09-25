package 24_GREEDY_PATTERN.TOP_10_PROBLEMS;

import java.util.Arrays;

/**
 * LeetCode 455. Assign Cookies
 * Category: Easy (Greedy + Sorting)
 */
public class assign_cookies {

    /**
     * Approach: Sort both and use Two Pointers
     * Give the smallest possible cookie that satisfies the child's greed.
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(1)
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int child = 0;
        int cookie = 0;
        
        while (child < g.length && cookie < s.length) {
            if (s[cookie] >= g[child]) {
                child++; // Child is content
            }
            cookie++; // Move to next cookie
        }
        
        return child;
    }

    /*
     * FAANG Interview Note:
     * Sorting is almost always the first step in greedy problems 
     * involving two sets of data.
     */
}
