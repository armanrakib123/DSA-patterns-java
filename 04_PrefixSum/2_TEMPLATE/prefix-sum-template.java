package 

03_PREFIX_SUM_PATTERN.TEMPLATE;

import java.util.HashMap;
import java.util.Map;

/**
 * Software Company Standard Prefix Sum Templates This class contains standard
 * patterns for Prefix Sum.
 */
public class prefix_sum_template {

    /**
     * 1. 1-Based Prefix Sum Array for Range Queries Time: Preprocessing O(N),
     * Query O(1) Space: O(N)
     */
    public static class RangeSumQuery {

        private long[] prefix;

        public RangeSumQuery(int[] nums) {
            int n = nums.length;
            prefix = new long[n + 1]; // 1-based indexing
            for (int i = 0; i < n; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
        }

        // Returns sum of elements from index left to right (inclusive)
        public long query(int left, int right) {
            return prefix[right + 1] - prefix[left];
        }
    }

    /**
     * 2. Running Sum with HashMap for "Subarray Sum Equals K" pattern Time:
     * O(N) Space: O(N)
     */
    public static int subarraySumEqualsK(int[] nums, int k) {
        int count = 0;
        long currentSum = 0;

        // Map to store frequency of prefix sums
        Map<Long, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0L, 1); // Base case for subarrays starting at index 0

        for (int num : nums) {
            currentSum += num;

            // Check if (currentSum - k) exists in map
            if (prefixMap.containsKey(currentSum - k)) {
                count += prefixMap.get(currentSum - k);
            }

            // Update the map with current sum
            prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    /**
     * 3. In-place Prefix Sum (When modification is allowed) Time: O(N) Space:
     * O(1)
     */
    public static void inPlacePrefixSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
    }
}
