package 23_HEAP_PRIORITY_QUEUE_PATTERN.TOP_10_PROBLEMS;

import java.util.PriorityQueue;

/**
 * LeetCode 973. K Closest Points to Origin
 * Category: Medium (Heap with custom distance)
 */
public class k_closest_points_to_origin {

    /**
     * Approach: Max-Heap of size K
     * We want the K SMALLEST distances, so we use a MAX-HEAP of size K.
     * 
     * Time Complexity: O(N log K)
     * Space Complexity: O(K)
     */
    public int[][] kClosest(int[][] points, int k) {
        // Max-heap stores points with larger distances at the top
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            Integer.compare(b[0]*b[0] + b[1]*b[1], a[0]*a[0] + a[1]*a[1]));
            
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > k) {
                pq.poll(); // Remove the farthest point among the k+1
            }
        }
        
        int[][] res = new int[k][2];
        while (k > 0) {
            res[--k] = pq.poll();
        }
        return res;
    }

    /*
     * FAANG Interview Note:
     * This is a "Top K" problem. 
     * Remember: "K Smallest -> Max Heap", "K Largest -> Min Heap".
     */
}
