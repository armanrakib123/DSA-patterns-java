package 07_BINARY_SEARCH_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 153. Find Minimum in Rotated Sorted Array
 * Category: Medium (FAANG Favorite)
 * 
 * Problem: Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * You must write an algorithm that runs in O(log n) time.
 */
public class find_minimum_rotated {

    /**
     * Approach: Binary Search for the Inflection Point
     * In a rotated sorted array, the minimum element is the only element that is smaller than its previous element.
     * 
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */
    public int findMin(int[] nums) {
        // If array is not rotated at all (or rotated n times)
        if (nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Did we find the inflection point directly?
            // If mid element is greater than its next element, then mid+1 is the minimum
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            // If mid element is smaller than its previous element, then mid is the minimum
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            
            // Where to search next?
            // If the left half is sorted, the anomaly (minimum) MUST be in the right half
            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } 
            // Otherwise, the left half has the anomaly
            else {
                right = mid - 1;
            }
        }
        
        return -1;
    }

    /*
     * FAANG Interview Note:
     * Alternatively, you can use the `left < right` template.
     * If `nums[mid] > nums[right]`, we know the min is to the right (`left = mid + 1`).
     * Else, the min is to the left or exactly mid (`right = mid`).
     * Both approaches are perfectly valid, but explicit inflection point checking 
     * often makes more intuitive sense to explain during an interview.
     */
}
