package 

15_FAST_SLOW_POINTER_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 287. Find the Duplicate Number
 * Category: Medium (Cycle Detection in Array)
 * 
 * Problem: Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 */
public class find_duplicate_number {

    /**
     * Approach: Floyd's Cycle-Finding Algorithm (Fast & Slow) Treat the array
     * as a linked list where nums[i] is the pointer to the next index. Since
     * there's a duplicate, there will be multiple pointers to the same index,
     * creating a cycle.
     *
     * Time Complexity: O(N) Space Complexity: O(1)
     */
    public int findDuplicate(int[] nums) {
        // Step 1: Find collision point
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Step 2: Find the entry point (the duplicate number)
        int slow2 = nums[0];
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }

    /*
     * Software Company Interview Note:
     * This is one of the most clever applications of Cycle Detection. 
     * Interviewers love it because it forces you to think of an array as a graph/linked list.
     */
}
