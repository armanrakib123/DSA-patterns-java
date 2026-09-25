package 

07_BINARY_SEARCH_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 162. Find Peak Element
 * Category: Medium (Google)
 * 
 * Problem: A peak element is an element that is strictly greater than its neighbors.
 * Given a 0-indexed integer array nums, find a peak element, and return its index. 
 * If the array contains multiple peaks, return the index to any of the peaks.
 * You may imagine that nums[-1] = nums[n] = -∞.
 * You must write an algorithm that runs in O(log n) time.
 */
public class find_peak_element {

    /**
     * Approach: Binary Search on Unsorted Array! Wait, how can we use binary
     * search on an unsorted array? Answer: Because we just need to find ANY
     * local peak, we can just walk "UP" the slope. If the slope is rising
     * (nums[mid] < nums[mid+1]), a peak MUST exist to the right.
     * If the slope is falling (nums[mid] > nums[mid+1]), a peak MUST exist to
     * the left.
     *
     * Time Complexity: O(log N) Space Complexity: O(1)
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Note: We use < here instead of <=. 
        // Why? Because we compare mid with mid+1. 
        // If left == right, left is our peak, so we break out of the loop and return left.
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check the slope: Is it rising?
            if (nums[mid] < nums[mid + 1]) {
                // We are on an upward slope. The peak must be to our right.
                // We don't include mid, because mid + 1 is greater than mid.
                left = mid + 1;
            } else {
                // We are on a downward slope. The peak must be to our left (or mid itself).
                // We INCLUDE mid, because mid could be the peak.
                right = mid;
            }
        }

        // Loop breaks when left == right. That single element is our peak.
        return left;
    }

    /*
     * Software Company Interview Note:
     * This problem breaks the misconception that "Binary Search only works on Sorted Arrays".
     * Binary search works on ANY array where you can confidently eliminate half of the search space based on a condition.
     * The `left < right` (without `=`) and `right = mid` pattern is very specific to this type of problem.
     */
}
