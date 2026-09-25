package 07_BINARY_SEARCH_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 704. Binary Search
 * Category: Easy
 * 
 * Problem: Given an array of integers nums which is sorted in ascending order, and an integer target, 
 * write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class binary_search {

    /**
     * Approach: Standard Iterative Binary Search
     * The foundational algorithm. Every programmer must write this blindfolded.
     * 
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 1. Inclusive right bound
        
        while (left <= right) { // 2. <= ensures we check the final single element
            
            // 3. Prevent Integer overflow: (left + right)/2 can overflow
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                // Target is larger, must be on the right side
                left = mid + 1; // 4. +1 prevents infinite loops
            } else {
                // Target is smaller, must be on the left side
                right = mid - 1; // 5. -1 prevents infinite loops
            }
        }
        
        return -1; // Target not found
    }

    /*
     * FAANG Interview Note:
     * If you mess up ANY of the 5 numbered points above during a phone screen, 
     * the interview is usually over. This is the "Hello World" of FAANG interviews.
     * Always remember: `left <= right` and `mid = left + (right - left) / 2`.
     */
}
