package 

08_BINARY_SEARCH_ON_ANSWER_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 875. Koko Eating Bananas
 * Category: Medium (Software Company Favorite - The easiest entry into BS on Answer)
 * 
 * Problem: Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. 
 * The guards have gone and will come back in h hours.
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas 
 * and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead 
 * and will not eat any more bananas during this hour.
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 */
public class koko_eating_bananas {

    /**
     * Approach: Binary Search on Answer The answer 'k' (speed) must be between
     * 1 and the maximum pile size. We binary search for the MINIMUM 'k' that
     * allows her to finish within 'h' hours.
     *
     * Time Complexity: O(N log M) where N is piles length, M is the max pile
     * size. Space Complexity: O(1)
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; // Minimum possible speed
        int right = 0; // Maximum possible speed (max pile size)

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int ans = right; // Worst case scenario

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                ans = mid; // Possible! But we want the minimum, so try to find a slower speed
                right = mid - 1;
            } else {
                left = mid + 1; // Too slow, must eat faster
            }
        }

        return ans;
    }

    /**
     * Helper: Checks if it's possible to eat all bananas at speed 'k' within
     * 'h' hours.
     */
    private boolean canFinish(int[] piles, int h, int k) {
        long hoursNeeded = 0; // Use long to prevent integer overflow during sum

        for (int pile : piles) {
            // Math.ceil((double) pile / k) equivalent without float conversion:
            // This is a pro Software Company trick! (A + B - 1) / B
            hoursNeeded += (pile + k - 1) / k;

            // Early exit optimization
            if (hoursNeeded > h) {
                return false;
            }
        }

        return hoursNeeded <= h;
    }

    /*
     * Software Company Interview Note:
     * The math trick `(pile + k - 1) / k` is brilliant. 
     * If pile = 7, k = 3. `(7 + 3 - 1) / 3 = 9 / 3 = 3`. (Since 7/3 requires 3 hours: 3, 3, 1).
     * If pile = 6, k = 3. `(6 + 3 - 1) / 3 = 8 / 3 = 2`.
     * Using this instead of `Math.ceil()` avoids double division overhead.
     */
}
