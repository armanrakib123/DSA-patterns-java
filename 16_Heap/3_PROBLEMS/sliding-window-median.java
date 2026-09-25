package 

23_HEAP_PRIORITY_QUEUE_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 480. Sliding Window Median Category: Hard (Two Heaps with Lazy
 * Deletion)
 */
public class sliding_window_median {

    /**
     * Approach: Two Heaps (TreeMap is easier in Java for lazy deletion)
     *
     * Time Complexity: O(N log k) Space Complexity: O(k)
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] result = new double[n - k + 1];

        // Use TreeMaps to simulate Heaps with efficient middle access and lazy deletion
        TreeMap<Integer, Integer> small = new TreeMap<>(); // Max-heap part
        TreeMap<Integer, Integer> large = new TreeMap<>(); // Min-heap part
        int smallSize = 0, largeSize = 0;

        for (int i = 0; i < n; i++) {
            // 1. Add current element
            if (smallSize <= largeSize) {
                add(small, nums[i]);
                smallSize++;
                // Balance: move largest from small to large
                int largestFromSmall = small.lastKey();
                remove(small, largestFromSmall);
                add(large, largestFromSmall);
                smallSize--;
                largeSize++;
            } else {
                add(large, nums[i]);
                largeSize++;
                // Balance: move smallest from large to small
                int smallestFromLarge = large.firstKey();
                remove(large, smallestFromLarge);
                add(small, smallestFromLarge);
                largeSize--;
                smallSize++;
            }

            // 2. Remove element that is out of window
            if (i >= k) {
                int out = nums[i - k];
                if (small.containsKey(out)) {
                    remove(small, out);
                    smallSize--;
                } else {
                    remove(large, out);
                    largeSize--;
                }
            }

            // 3. Re-balance sizes after removal
            if (smallSize > largeSize + 1) {
                int val = small.lastKey();
                remove(small, val);
                add(large, val);
                smallSize--;
                largeSize++;
            } else if (largeSize > smallSize) {
                int val = large.firstKey();
                remove(large, val);
                add(small, val);
                largeSize--;
                smallSize++;
            }

            // 4. Calculate Median
            if (i >= k - 1) {
                if (k % 2 == 1) {
                    result[i - k + 1] = small.lastKey();
                } else {
                    result[i - k + 1] = ((double) small.lastKey() + large.firstKey()) / 2.0;
                }
            }
        }

        return result;
    }

    private void add(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    private void remove(TreeMap<Integer, Integer> map, int val) {
        int count = map.get(val);
        if (count == 1) {
            map.remove(val); 
        }else {
            map.put(val, count - 1);
        }
    }

    /*
     * Software Company Interview Note:
     * While Two Heaps works, Java's `PriorityQueue` does not support O(log N) 
     * removal of an arbitrary element. `TreeMap` is the professional way 
     * to solve this efficiently in Java.
     */
}
