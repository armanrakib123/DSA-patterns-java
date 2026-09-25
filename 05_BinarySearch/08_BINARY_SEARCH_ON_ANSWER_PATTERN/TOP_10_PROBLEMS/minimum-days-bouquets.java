package 08_BINARY_SEARCH_ON_ANSWER_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 1482. Minimum Number of Days to Make m Bouquets
 * Category: Medium
 * 
 * Problem: You are given an integer array bloomDay, an integer m and an integer k.
 * You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
 * The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
 * Return the minimum number of days you need to wait to be able to make m bouquets from the garden. 
 * If it is impossible to make m bouquets return -1.
 */
public class minimum_days_bouquets {

    /**
     * Approach: Binary Search on Answer
     * The answer (days) lies between the minimum day and the maximum day in bloomDay array.
     * We binary search the days and check if we can form 'm' bouquets of 'k' adjacent flowers on that day.
     * 
     * Time Complexity: O(N log(Max - Min))
     * Space Complexity: O(1)
     */
    public int minDays(int[] bloomDay, int m, int k) {
        // Impossible case: we need m * k flowers, but array has less
        // Using long to prevent overflow if m * k is very large
        if ((long) m * k > bloomDay.length) {
            return -1;
        }
        
        int minDay = Integer.MAX_VALUE;
        int maxDay = 0;
        
        for (int day : bloomDay) {
            minDay = Math.min(minDay, day);
            maxDay = Math.max(maxDay, day);
        }
        
        int low = minDay;
        int high = maxDay;
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canMakeBouquets(bloomDay, mid, m, k)) {
                ans = mid; // Possible! But try an earlier day
                high = mid - 1;
            } else {
                low = mid + 1; // Not enough flowers bloomed, wait longer
            }
        }
        
        return ans;
    }
    
    /**
     * Helper: Checks if we can make 'm' bouquets of 'k' ADJACENT flowers on day 'day'.
     */
    private boolean canMakeBouquets(int[] bloomDay, int day, int m, int k) {
        int bouquetsMade = 0;
        int adjacentFlowers = 0;
        
        for (int bloom : bloomDay) {
            // Is the flower bloomed on this day?
            if (bloom <= day) {
                adjacentFlowers++;
                // Do we have enough for one bouquet?
                if (adjacentFlowers == k) {
                    bouquetsMade++;
                    adjacentFlowers = 0; // Reset for the next bouquet
                }
            } 
            // If the chain is broken, reset adjacent flowers
            else {
                adjacentFlowers = 0;
            }
            
            // Early exit optimization
            if (bouquetsMade >= m) {
                return true;
            }
        }
        
        return bouquetsMade >= m;
    }

    /*
     * FAANG Interview Note:
     * The condition "ADJACENT flowers" is the trick here.
     * That's why we reset `adjacentFlowers = 0` the moment we find a flower that hasn't bloomed.
     * Also, checking `(long) m * k > bloomDay.length` using a cast to `long` is highly 
     * appreciated by Google interviewers to avoid integer overflow.
     */
}
