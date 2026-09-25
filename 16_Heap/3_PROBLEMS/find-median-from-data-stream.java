package 23_HEAP_PRIORITY_QUEUE_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 295. Find Median from Data Stream
 * Category: Hard (Two Heaps Pattern)
 */
public class find_median_from_data_stream {

    class MedianFinder {
        // maxHeap for the lower half, minHeap for the upper half
        private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
        private PriorityQueue<Integer> large = new PriorityQueue<>();

        /**
         * Approach: Two Heaps
         * Maintain two heaps such that the difference in size is at most 1.
         * 
         * Time Complexity: O(log N) for addNum, O(1) for findMedian
         * Space Complexity: O(N)
         */
        public void addNum(int num) {
            small.offer(num);
            large.offer(small.poll());
            
            if (small.size() < large.size()) {
                small.offer(large.poll());
            }
        }

        public double findMedian() {
            if (small.size() > large.size()) {
                return small.peek();
            }
            return (small.peek() + large.peek()) / 2.0;
        }
    }

    /*
     * FAANG Interview Note:
     * This is the definitive "Two Heaps" problem. 
     * It perfectly demonstrates how two heaps can provide O(1) access to 
     * the middle of a dynamic sorted collection.
     */
}
