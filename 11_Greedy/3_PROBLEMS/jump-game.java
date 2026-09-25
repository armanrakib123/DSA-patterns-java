package 24_GREEDY_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 55. Jump Game
 * Category: Medium (Greedy)
 * 
 * Problem: You are initially positioned at the array's first index, 
 * and each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 */
public class jump_game {

    /**
     * Approach: Greedy (Track maximum reachable index)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            // If current index is beyond maxReach, we can't move forward
            if (i > maxReach) return false;
            
            // Update maxReach from current position
            maxReach = Math.max(maxReach, i + nums[i]);
            
            // Optimization: if we can already reach the end, return true
            if (maxReach >= nums.length - 1) return true;
        }
        return true;
    }

    /*
     * FAANG Interview Note:
     * This problem can also be solved with DP, but DP takes O(N^2) time. 
     * The Greedy O(N) approach is what makes you stand out.
     */
}
