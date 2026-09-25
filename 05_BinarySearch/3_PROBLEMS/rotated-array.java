package 07_BINARY_SEARCH_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 33. Search in Rotated Sorted Array
 * Category: Medium (FAANG Favorite - Almost always asked at Meta/Amazon)
 * 
 * Problem: There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index.
 * Given the array nums after the possible rotation and an integer target, 
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class rotated_array {

    /**
     * Approach: One Half is Always Sorted
     * If we split a rotated sorted array from the middle, at least one of the two halves 
     * WILL always be perfectly sorted. We use this fact to decide which half to discard.
     * 
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid; // Found it
            }
            
            // Check if the LEFT half is sorted
            // (Notice the <= here, it's crucial when left == mid)
            if (nums[left] <= nums[mid]) {
                
                // If target lies strictly inside this sorted left half
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Target is here, discard right half
                } else {
                    left = mid + 1;  // Target is NOT here, discard left half
                }
                
            } 
            // If left half is NOT sorted, then the RIGHT half MUST be sorted
            else {
                
                // If target lies strictly inside this sorted right half
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1; // Target is here, discard left half
                } else {
                    right = mid - 1; // Target is NOT here, discard right half
                }
                
            }
        }
        
        return -1; // Not found
    }

    /*
     * FAANG Interview Note:
     * This logic is the absolute core of dealing with Rotated Arrays.
     * Make sure you use `target >= nums[left]` (greater than OR equal) because the 
     * target could exactly be the boundary element.
     * Missing the equals sign in `nums[left] <= nums[mid]` or `target >= nums[left]` 
     * are the most common reasons candidates fail this problem.
     */
}
