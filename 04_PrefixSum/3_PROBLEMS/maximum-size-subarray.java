package 

03_PREFIX_SUM_PATTERN.TOP_10_PROBLEMS;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 325. Maximum Size Subarray Sum Equals k Category: Medium (Premium
 * problem, highly asked at Meta)
 *
 * Problem: Given an integer array nums and an integer k, return the maximum
 * length of a subarray that sums to k. If there isn't one, return 0 instead.
 */
public class maximum_size_subarray {

    /**
     * Approach: Prefix Sum + HashMap We want to find max(i - j) such that
     * PrefixSum[i] - PrefixSum[j] = k. So we look for PrefixSum[j] =
     * PrefixSum[i] - k in our map. To maximize (i - j), we need to MINIMIZE j.
     * Thus, we only store the EARLIEST index we see a particular prefix sum.
     *
     * Time Complexity: O(N) Space Complexity: O(N)
     */
    public int maxSubArrayLen(int[] nums, int k) {
        int maxLength = 0;
        long currentSum = 0;

        // Map to store <PrefixSum, Earliest Index>
        Map<Long, Integer> map = new HashMap<>();

        // Base case: to handle subarrays starting from index 0
        map.put(0L, -1);

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            // If we've seen (currentSum - k) before, we have a valid subarray
            if (map.containsKey(currentSum - k)) {
                int length = i - map.get(currentSum - k);
                maxLength = Math.max(maxLength, length);
            }

            // Only insert the prefix sum if it is not already in the map.
            // This ensures we keep the smallest index to maximize length.
            if (!map.containsKey(currentSum)) {
                map.put(currentSum, i);
            }
        }

        return maxLength;
    }

    /*
     * Software Company Interview Note:
     * This problem highlights a crucial difference from "Subarray Sum Equals K" (LC 560).
     * In LC 560, we counted frequency: map.put(sum, map.getOrDefault() + 1).
     * Here, we maximize length, so we store the earliest index: if(!map.containsKey) map.put(sum, i).
     * Mixing these two up is a very common interview mistake.
     */
}
