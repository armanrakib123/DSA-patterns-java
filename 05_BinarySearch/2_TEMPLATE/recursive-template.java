package 

07_BINARY_SEARCH_PATTERN.TEMPLATE;

/**
 * Software Company Standard Recursive Binary Search Templates
 * Useful for trees, graphs, and Divide & Conquer problems.
 */
public class recursive_template {

    /**
     * Standard Recursive Binary Search Time: O(log N) Space: O(log N) due to
     * call stack
     */
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int left, int right) {
        // Base Case: Not found
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid; // Found it
        } else if (nums[mid] < target) {
            // Target is in the right half
            return search(nums, target, mid + 1, right);
        } else {
            // Target is in the left half
            return search(nums, target, left, mid - 1);
        }
    }
}
