package 

23_HEAP_PRIORITY_QUEUE_PATTERN.TOP_10_PROBLEMS;

import java.util.PriorityQueue;

/**
 * LeetCode 215. Kth Largest Element in an Array Category: Medium (Fundamental
 * Heap)
 *
 * Problem: Given an integer array nums and an integer k, return the kth largest
 * element in the array.
 */
public class kth_largest_element_array {

    /**
     * Approach: Min-Heap Maintain a min-heap of size k. The top of the heap
     * will always be the k-th largest element.
     *
     * Time Complexity: O(N log k) Space Complexity: O(k)
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    /*
     * Software Company Interview Note:
     * There is also an O(N) average-time solution called "QuickSelect". 
     * However, the Heap solution is much more stable and easier to implement.
     */
}
