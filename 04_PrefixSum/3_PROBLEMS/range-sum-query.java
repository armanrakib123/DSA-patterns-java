package 

03_PREFIX_SUM_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 303. Range Sum Query - Immutable
 * Category: Easy
 * 
 * Problem: Given an integer array nums, handle multiple queries of the following type:
 * Calculate the sum of the elements of nums between indices left and right inclusive.
 */
public class range_sum_query {

    /**
     * Approach: 1-Based Prefix Sum Array To answer Q queries in O(1) time each,
     * we preprocess the array in O(N) time.
     */
    class NumArray {

        private int[] prefix;

        public NumArray(int[] nums) {
            // Create an array of size N + 1
            prefix = new int[nums.length + 1];

            // prefix[i+1] will store the sum of nums from 0 to i
            for (int i = 0; i < nums.length; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
        }

        // Time Complexity: O(1) per query
        public int sumRange(int left, int right) {
            // Using 1-based index avoids out-of-bounds when left == 0
            return prefix[right + 1] - prefix[left];
        }
    }

    /*
     * Software Company Interview Note:
     * This is the exact implementation pattern you should use anytime you need 
     * fast range sums inside a larger, more complex algorithm. The 1-based indexing 
     * technique is highly appreciated by interviewers as it leads to cleaner, bug-free code.
     */
}
