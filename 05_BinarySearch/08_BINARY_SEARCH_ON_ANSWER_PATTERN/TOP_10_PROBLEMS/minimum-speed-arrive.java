package 08_BINARY_SEARCH_ON_ANSWER_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 1870. Minimum Speed to Arrive on Time
 * Category: Medium
 * 
 * Problem: You are given a floating-point number hour, representing the amount of time you have to reach the office.
 * To commute to the office, you must take n trains in sequential order. You are also given an integer array dist.
 * Each train can only depart at an integer hour, so you may need to wait in between each train ride.
 * Return the minimum positive integer speed (in kilometers per hour) that all the trains must travel at for you 
 * to reach the office on time, or -1 if it is impossible to be on time.
 */
public class minimum_speed_arrive {

    /**
     * Approach: Binary Search on Answer
     * The answer is the speed. What is the minimum possible speed? 1.
     * What is the maximum possible speed? According to the problem constraints, it's 10^7.
     * 
     * Time Complexity: O(N log(10^7)) = O(N)
     * Space Complexity: O(1)
     */
    public int minSpeedOnTime(int[] dist, double hour) {
        // Impossible to reach if we have more trains (excluding the last one) than hours
        // Because each train (except the last) takes at least 1 hour (due to integer hour departure).
        if (Math.ceil(hour) < dist.length) {
            return -1;
        }
        
        int low = 1;
        int high = 10000000; // From constraints: 10^7
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canReachInTime(dist, hour, mid)) {
                ans = mid; // Valid speed, but we want the minimum, so try slower
                high = mid - 1;
            } else {
                low = mid + 1; // Too slow, increase speed
            }
        }
        
        return ans;
    }
    
    private boolean canReachInTime(int[] dist, double hourLimit, int speed) {
        double timeTaken = 0;
        
        for (int i = 0; i < dist.length; i++) {
            double timeForThisTrain = (double) dist[i] / speed;
            
            // Wait for the next integer hour, UNLESS it's the very last train
            if (i < dist.length - 1) {
                timeTaken += Math.ceil(timeForThisTrain);
            } else {
                timeTaken += timeForThisTrain;
            }
        }
        
        return timeTaken <= hourLimit;
    }

    /*
     * FAANG Interview Note:
     * This problem is notorious for Precision Issues!
     * Using `Math.ceil((double) dist[i] / speed)` is required here instead of the 
     * `(pile + speed - 1) / speed` trick because the `hour` limit is a double (e.g., 2.73 hours).
     * If you are getting wrong answers on edge cases involving floating point limits,
     * check how you are comparing `timeTaken <= hourLimit`.
     */
}
