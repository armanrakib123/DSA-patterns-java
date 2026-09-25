package 07_BINARY_SEARCH_PATTERN.TEMPLATE;

/**
 * FAANG Standard Iterative Binary Search Templates
 * Master this and you can solve 90% of binary search problems.
 */
public class iterative_template {

    /**
     * Template 1: Standard Binary Search
     * Used to find the exact target element.
     */
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // Inclusive bounds
        
        while (left <= right) { // <= is critical
            // Prevent integer overflow: equivalent to (left + right) / 2
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid; // Found it
            } else if (nums[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return -1; // Not found
    }

    /**
     * Template 2: Find First Occurrence (Lower Bound / Search Insert Position)
     * Used when duplicates exist, or we need the insertion point.
     */
    public int findFirstOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1; // Default if not found
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                result = mid; // Record the answer
                right = mid - 1; // But keep searching LEFT for earlier occurrences
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // Note: For Search Insert Position (LeetCode 35), just return 'left' instead of 'result'
        return result; 
    }

    /**
     * Template 3: Find Last Occurrence (Upper Bound variant)
     * Used when duplicates exist.
     */
    public int findLastOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                result = mid; // Record the answer
                left = mid + 1; // But keep searching RIGHT for later occurrences
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result; 
    }
}
