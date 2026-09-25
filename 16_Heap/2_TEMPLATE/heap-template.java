package 23_HEAP_PRIORITY_QUEUE_PATTERN.TEMPLATE;

import java.util.*;

/**
 * FAANG Standard Heap & Priority Queue Templates
 */
public class heap_template {

    /**
     * Template 1: Top K Elements using Min-Heap
     * Finds the k largest elements in an array.
     * Time Complexity: O(N log k)
     * Space Complexity: O(k)
     */
    public List<Integer> topKLargest(int[] nums, int k) {
        // Min-heap keeps the 'k' largest elements at the bottom
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest of the top k
            }
        }
        
        return new ArrayList<>(minHeap);
    }

    /**
     * Template 2: Two Heaps Pattern (Median Finder)
     * Maintains a median in a dynamic data stream.
     */
    class MedianFinder {
        // maxHeap stores the smaller half, minHeap stores the larger half
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        public void addNum(int num) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            
            // Balance sizes
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    /**
     * Template 3: K-Way Merge using Heap
     * Standard logic for merging k sorted lists or arrays.
     */
    public void kWayMerge() {
        // PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        // Add heads of all lists to pq...
        // While pq is not empty, poll smallest and add its next element...
    }
}
