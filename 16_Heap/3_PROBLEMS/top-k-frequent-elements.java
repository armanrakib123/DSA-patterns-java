package 

23_HEAP_PRIORITY_QUEUE_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 347. Top K Frequent Elements Category: Medium (HashMap + Heap)
 */
public class top_k_frequent_elements {

    /**
     * Approach: HashMap + Min-Heap 1. Count frequencies using a HashMap. 2. Use
     * a Min-Heap of size k to keep track of the most frequent elements.
     *
     * Time Complexity: O(N log k) Space Complexity: O(N)
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // Min-heap based on frequency
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));

        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] top = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            top[i] = heap.poll();
        }
        return top;
    }

    /*
     * Software Company Interview Note:
     * This problem is about sorting data by a derived property (frequency). 
     * Using a heap is the most flexible way to do this.
     */
}
