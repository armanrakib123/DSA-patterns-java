package 

08_BINARY_SEARCH_ON_ANSWER_PATTERN.TEMPLATE;

/**
 * Software Company Standard Binary Search on Answer Template
 */
public class answer_search_template {

    /**
     * Template for: Finding the MINIMUM possible answer (F F F T T T pattern)
     * e.g., Koko Eating Bananas, Capacity to Ship Packages
     */
    public int findMinimum(int[] nums, int targetLimit) {
        // Step 1: Define the tightest possible search space
        long low = getMinimumPossible(nums); // e.g., max element
        long high = getMaximumPossible(nums); // e.g., sum of all elements
        long ans = -1;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            // Step 2: Feasibility check
            if (isValid(nums, mid, targetLimit)) {
                ans = mid; // It's possible! Record it.
                high = mid - 1; // But we want the MINIMUM, so try to find a smaller one (go left)
            } else {
                low = mid + 1; // Not possible. We need a larger capacity (go right)
            }
        }

        return (int) ans;
    }

    /**
     * Template for: Finding the MAXIMUM possible answer (T T T F F F pattern)
     * e.g., Aggressive Cows, Maximum Distance
     */
    public int findMaximum(int[] nums, int itemsToPlace) {
        long low = 1; // Minimum possible distance
        long high = getMaximumPossible(nums); // Max spread
        long ans = -1;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (isPossibleToPlace(nums, mid, itemsToPlace)) {
                ans = mid; // It's possible! Record it.
                low = mid + 1; // But we want the MAXIMUM, so try to find a larger one (go right)
            } else {
                high = mid - 1; // Not possible. Distance is too big (go left)
            }
        }

        return (int) ans;
    }

    // --- Helper Functions Skeletons ---
    private boolean isValid(int[] nums, long mid, int limit) {
        int count = 1;
        long currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > mid) {
                count++;
                currentSum = num;
            } else {
                currentSum += num;
            }
        }
        return count <= limit;
    }

    private boolean isPossibleToPlace(int[] nums, long mid, int itemsToPlace) {
        int count = 1;
        long lastPlacedPosition = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - lastPlacedPosition >= mid) {
                count++;
                lastPlacedPosition = nums[i];
            }
        }
        return count >= itemsToPlace;
    }

    private long getMinimumPossible(int[] nums) {
        long max = 0;
        for (int n : nums) {
            max = Math.max(max, n);
        }
        return max;
    }

    private long getMaximumPossible(int[] nums) {
        long sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return sum;
    }
}
