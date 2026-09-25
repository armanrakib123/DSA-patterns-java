package 08_BINARY_SEARCH_ON_ANSWER_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 1011. Capacity To Ship Packages Within D Days
 * Category: Medium (Amazon/Google)
 * 
 * Problem: A conveyor belt has packages that must be shipped from one port to another within days days.
 * The ith package on the conveyor belt has a weight of weights[i].
 * Return the least weight capacity of the ship that will result in all the packages 
 * being shipped within days days.
 */
public class capacity_to_ship {

    /**
     * Approach: Binary Search on Answer
     * Search space:
     * Minimum capacity = Maximum weight in the array (otherwise the heaviest package can NEVER be shipped).
     * Maximum capacity = Sum of all weights (if we ship everything in 1 day).
     * 
     * Time Complexity: O(N log(Sum - Max)) 
     * Space Complexity: O(1)
     */
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0;
        int totalWeight = 0;
        
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }
        
        int low = maxWeight;
        int high = totalWeight;
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isPossible(weights, mid, days)) {
                ans = mid; // Valid capacity, but try to find a smaller one
                high = mid - 1;
            } else {
                low = mid + 1; // Capacity too small, increase it
            }
        }
        
        return ans;
    }
    
    /**
     * Helper: Checks if given capacity can ship all weights within the required days.
     */
    private boolean isPossible(int[] weights, int capacity, int requiredDays) {
        int daysUsed = 1; // We start shipping on day 1
        int currentLoad = 0;
        
        for (int weight : weights) {
            // If the package itself is heavier than capacity, it's impossible.
            // (Note: This is technically covered by setting 'low' to maxWeight, 
            // but it's good practice to include it for robust code).
            if (weight > capacity) return false;
            
            // If adding this package exceeds capacity, it goes to the next day
            if (currentLoad + weight > capacity) {
                daysUsed++;
                currentLoad = weight; // Start the new day with this package
            } else {
                currentLoad += weight; // Continue adding to current day
            }
            
            // Early exit
            if (daysUsed > requiredDays) {
                return false;
            }
        }
        
        return daysUsed <= requiredDays;
    }

    /*
     * FAANG Interview Note:
     * The core logic inside `isPossible` is identical to "Split Array Largest Sum".
     * Recognizing that these two problems are essentially the SAME problem wrapped 
     * in different English stories is what makes you a master.
     */
}
