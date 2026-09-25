package 07_BINARY_SEARCH_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 34. Find First and Last Position of Element in Sorted Array
 * Category: Medium (FAANG Favorite - Google/Meta)
 * 
 * Problem: Given an array of integers nums sorted in non-decreasing order, 
 * find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class first_last_position {

    /**
     * Approach: Two Binary Searches (Lower Bound and Upper Bound)
     * We cannot just find the element and expand outwards linearly, because if all elements 
     * are the target, expansion takes O(N) time.
     * We MUST do two separate O(log N) binary searches.
     * 
     * Time Complexity: O(log N) + O(log N) = O(log N)
     * Space Complexity: O(1)
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        if (nums == null || nums.length == 0) return result;
        
        result[0] = findFirst(nums, target);
        // Optimization: If first is not found, last won't be found either
        if (result[0] != -1) {
            result[1] = findLast(nums, target);
        }
        
        return result;
    }
    
    // Equivalent to C++ lower_bound
    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int firstPos = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                firstPos = mid; // Record it
                right = mid - 1; // Keep searching LEFT
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return firstPos;
    }
    
    // Equivalent to C++ upper_bound variant
    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int lastPos = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                lastPos = mid; // Record it
                left = mid + 1; // Keep searching RIGHT
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return lastPos;
    }

    /*
     * FAANG Interview Note:
     * This is the true test of your Binary Search foundation. 
     * Trying to combine both searches into one loop is a common mistake and usually leads to spaghetti code.
     * The clean, professional way is to write two helper functions.
     */
}
