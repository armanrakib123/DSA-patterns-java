package 26_1D_DYNAMIC_PROGRAMMING_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 213. House Robber II
 * Category: Medium (Circular 1D DP)
 * 
 * Problem: Houses are arranged in a circle. You cannot rob the first and last house together.
 */
public class house_robber_ii {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        // Either skip the last house OR skip the first house
        return Math.max(robHelper(nums, 0, nums.length - 2), 
                        robHelper(nums, 1, nums.length - 1));
    }
    
    private int robHelper(int[] nums, int start, int end) {
        int prev2 = 0, prev1 = 0;
        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    /*
     * FAANG Interview Note:
     * To solve circular DP, break it into two linear DP cases.
     */
}
