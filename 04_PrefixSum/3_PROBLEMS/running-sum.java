package 03_PREFIX_SUM_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 1480. Running Sum of 1d Array
 * Category: Easy
 * 
 * Problem: Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]...nums[i]).
 * Return the running sum of nums.
 */
public class running_sum {
    
    /**
     * Approach: In-place Prefix Sum
     * We don't need extra space because we can modify the input array to hold the running sums.
     * 
     * Time Complexity: O(N), where N is the length of nums.
     * Space Complexity: O(1) if modifying input, O(N) if a new array is required.
     */
    public int[] runningSum(int[] nums) {
        // Start from index 1 because the first element's running sum is itself
        for (int i = 1; i < nums.length; i++) {
            // Add previous sum to current element
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }

    /*
     * FAANG Interview Note: 
     * Even for an "Easy" problem, you should clarify if you are allowed to mutate the input array.
     * In Production environments, mutating arguments is often considered a bad practice due to side effects.
     * If the interviewer asks for immutability, create a new array.
     */
    public int[] runningSumImmutable(int[] nums) {
        int[] prefix = new int[nums.length];
        if (nums.length == 0) return prefix;
        
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        return prefix;
    }
}
