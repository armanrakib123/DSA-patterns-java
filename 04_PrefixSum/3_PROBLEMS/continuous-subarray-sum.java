package 

03_PREFIX_SUM_PATTERN.TOP_10_PROBLEMS;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 523. Continuous Subarray Sum Category: Medium (Facebook/Meta
 * frequent)
 *
 * Problem: Given an integer array nums and an integer k, return true if nums
 * has a good subarray or false otherwise. A good subarray is a subarray where:
 * 1. its length is at least two, and 2. the sum of the elements of the subarray
 * is a multiple of k.
 */
public class continuous_subarray_sum {

    /**
     * Approach: Prefix Sum + HashMap + Modulo Math Math concept: If (sum_j % k)
     * == (sum_i % k), then the subarray from i+1 to j is a multiple of k. E.g.
     * 23 % 6 = 5, and 29 % 6 = 5. Difference between 29 and 23 is 6, which is a
     * multiple of 6.
     *
     * Time Complexity: O(N) Space Complexity: O(min(N, K)) for HashMap
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        // Map to store <PrefixSum Modulo, Earliest Index seen>
        Map<Integer, Integer> map = new HashMap<>();

        // Base case: we imagine a sum of 0 at index -1 before the array starts
        // This handles cases where a prefix itself from index 0 is a multiple of k
        map.put(0, -1);

        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            // Calculate modulo
            int remainder = currentSum % k;

            // Handle negative remainders if nums could have negative values 
            // (though in LC 523 nums are >= 0, it's good practice)
            if (remainder < 0) {
                remainder += k;
            }

            if (map.containsKey(remainder)) {
                // Check if length is at least 2
                if (i - map.get(remainder) > 1) {
                    return true;
                }
            } else {
                // Important: ONLY add if it doesn't exist, to keep the EARLIEST index
                // This maximizes the length of the subarray we can find.
                map.put(remainder, i);
            }
        }

        return false;
    }

    /*
     * Software Company Interview Note:
     * This problem tests your mathematical foundation.
     * The two main traps:
     * 1. Not handling the base case map.put(0, -1)
     * 2. Overwriting an existing modulo in the map instead of keeping the earliest index (which ensures length >= 2).
     */
}
