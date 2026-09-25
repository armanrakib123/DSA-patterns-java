package 07_BINARY_SEARCH_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 35. Search Insert Position
 * Category: Easy
 * 
 * Problem: Given a sorted array of distinct integers and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class search_insert_position {

    /**
     * Approach: Binary Search (Lower Bound)
     * When the standard `while (left <= right)` loop breaks, the `left` pointer 
     * exactly points to the index where the target SHOULD be inserted.
     * This is a mathematical property of this specific binary search template.
     * 
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                left = mid + 1; // Search right
            } else {
                right = mid - 1; // Search left
            }
        }
        
        // When loop breaks, left > right. 
        // 'left' will be pointing to the first element strictly greater than target,
        // which is exactly where the target should be inserted!
        return left;
    }

    /*
     * FAANG Interview Note:
     * Returning `left` instead of `-1` is the only difference between this and standard Binary Search.
     * This exact logic is what C++ developers call `lower_bound()`.
     * Memorize this property: At loop termination, `left` = insertion point.
     */
}
