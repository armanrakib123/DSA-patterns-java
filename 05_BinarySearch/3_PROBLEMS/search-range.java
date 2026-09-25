package 07_BINARY_SEARCH_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 34. Find First and Last Position of Element in Sorted Array (Alternative implementation)
 * Category: Medium
 * 
 * This is an alternative implementation to `first-last-position.java`.
 * Instead of writing two separate full binary search functions, we write ONE helper function 
 * that acts exactly like C++'s `lower_bound()`.
 */
public class search_range {

    /**
     * Approach: Lower Bound trick
     * lowerBound(target) gives the FIRST index where target can be inserted.
     * lowerBound(target + 1) gives the FIRST index where (target + 1) can be inserted.
     * Therefore, the last index of target is simply `lowerBound(target + 1) - 1`.
     * 
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[] {-1, -1};
        
        int start = findLowerBound(nums, target);
        
        // If target is not found at the calculated lower bound, it doesn't exist
        if (start == nums.length || nums[start] != target) {
            return new int[] {-1, -1};
        }
        
        // Find the lower bound for (target + 1) and subtract 1 to get the end of target
        int end = findLowerBound(nums, target + 1) - 1;
        
        return new int[] {start, end};
    }
    
    /**
     * Helper: Returns the first index where elements are >= target
     */
    private int findLowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] >= target) {
                // Potential answer, but keep searching left for earlier occurrences
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }

    /*
     * FAANG Interview Note:
     * This is the absolute cleanest and most senior-level code for this problem.
     * By writing just one `findLowerBound` function and passing `target + 1`, 
     * you reduce code duplication. Interviewers love this level of mathematical abstraction!
     */
}
