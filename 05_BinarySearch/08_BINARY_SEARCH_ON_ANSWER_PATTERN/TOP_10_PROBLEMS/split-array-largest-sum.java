package 08_BINARY_SEARCH_ON_ANSWER_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 410. Split Array Largest Sum
 * Category: Hard (Very famous DP / Binary Search problem)
 * 
 * Problem: Given an integer array nums and an integer k, split nums into k non-empty subarrays 
 * such that the largest sum of any subarray is minimized.
 * Return the minimized largest sum of the split.
 */
public class split_array_largest_sum {

    /**
     * Approach: Binary Search on Answer
     * This is fundamentally the EXACT same problem as "Capacity To Ship Packages Within D Days".
     * Think of elements as packages and 'k' as days. The largest sum is the ship capacity.
     * 
     * Time Complexity: O(N log(Sum - Max))
     * Space Complexity: O(1)
     */
    public int splitArray(int[] nums, int k) {
        int maxElement = 0;
        int totalSum = 0;
        
        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
            totalSum += num;
        }
        
        // The minimum possible largest sum is the max element (k = n)
        // The maximum possible largest sum is the total sum (k = 1)
        int low = maxElement;
        int high = totalSum;
        int ans = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isValid(nums, mid, k)) {
                ans = mid; // We can split with max sum 'mid'. Try for a smaller one.
                high = mid - 1;
            } else {
                low = mid + 1; // 'mid' is too small, we need more than 'k' splits.
            }
        }
        
        return ans;
    }
    
    /**
     * Helper: Checks if it is possible to split the array into at most 'k' parts 
     * such that no part has a sum greater than 'maxSum'.
     */
    private boolean isValid(int[] nums, int maxSum, int k) {
        int splits = 1; // We start with 1 part
        int currentSum = 0;
        
        for (int num : nums) {
            if (currentSum + num > maxSum) {
                // We must cut here and start a new split
                splits++;
                currentSum = num; // Start new part with current number
            } else {
                // Add to current split
                currentSum += num;
            }
            
            // Early exit
            if (splits > k) {
                return false;
            }
        }
        
        return splits <= k;
    }

    /*
     * FAANG Interview Note:
     * Interviewers will often ask you to solve this using Dynamic Programming first (O(N^2 * K)).
     * After you explain the DP approach, you say: "But since the answer space is monotonic, 
     * we can optimize this to O(N log(Sum)) using Binary Search on Answer."
     * This transition from DP to Binary Search shows true mastery.
     */
}
