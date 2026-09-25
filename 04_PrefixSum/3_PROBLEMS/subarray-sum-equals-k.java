package 

03_PREFIX_SUM_PATTERN.TOP_10_PROBLEMS;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 560. Subarray Sum Equals K Category: Medium (Software Company
 * Favorite)
 *
 * Problem: Given an array of integers nums and an integer k, return the total
 * number of subarrays whose sum equals to k. A subarray is a contiguous
 * non-empty sequence of elements within an array.
 */
public class subarray_sum_equals_k {

    /**
     * Approach: Prefix Sum + HashMap (Optimal) We calculate the running sum. If
     * (runningSum - k) exists in our map, it means we have found a subarray
     * that sums to k.
     *
     * Time Complexity: O(N) Space Complexity: O(N) for the HashMap
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;

        // Map to store <PrefixSum, Frequency>
        Map<Integer, Integer> map = new HashMap<>();

        // Base case: to handle subarrays that start from index 0
        map.put(0, 1);

        for (int num : nums) {
            currentSum += num; // Calculate running prefix sum

            // Check if there is a prefix sum we can remove to get target k
            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }

            // Add current prefix sum to the map
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    /*
     * Software Company Interview Note:
     * This is the "Holy Grail" of Prefix Sum problems. Interviewers will often start
     * by asking you to solve it in O(N^2) space/time, and then ask for optimization.
     * Explain WHY we need the map.put(0, 1) -> It's because if the currentSum exactly 
     * equals K, then currentSum - K = 0. We need to count that valid subarray.
     */
}
