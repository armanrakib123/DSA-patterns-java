package 

24_GREEDY_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 45. Jump Game II
 * Category: Medium (Greedy)
 * 
 * Problem: Minimum number of jumps to reach the last index.
 */
public class jump_game_ii {

    /**
     * Approach: Greedy (Jump by boundaries)
     *
     * Time Complexity: O(N) Space Complexity: O(1)
     */
    public int jump(int[] nums) {
        int jumps = 0;
        int currentJumpEnd = 0;
        int farthest = 0;

        // We don't need to jump from the last element
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // If we reached the end of the current jump's range
            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthest;
            }
        }

        return jumps;
    }

    /*
     * Software Company Interview Note:
     * This is essentially a BFS logic implemented with O(1) space. 
     * Each jump level expands the "boundary" of reachable indices.
     */
}
