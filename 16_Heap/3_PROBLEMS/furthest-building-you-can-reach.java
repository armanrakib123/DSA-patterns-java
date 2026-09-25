package 23_HEAP_PRIORITY_QUEUE_PATTERN.TOP_10_PROBLEMS;

import java.util.PriorityQueue;

/**
 * LeetCode 1642. Furthest Building You Can Reach
 * Category: Medium (Greedy + Min-Heap)
 */
public class furthest_building_you_can_reach {

    /**
     * Approach: Greedy (Use ladders for the largest jumps)
     * Use a Min-Heap to track the largest jumps where ladders were used.
     * If ladders are exhausted, use bricks for the smallest jump in the heap.
     * 
     * Time Complexity: O(N log L) where L is number of ladders
     * Space Complexity: O(L)
     */
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Stores jumps where ladders are used
        
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i+1] - heights[i];
            
            if (diff > 0) {
                pq.offer(diff);
                
                // If ladders are all used up
                if (pq.size() > ladders) {
                    // Use bricks for the smallest jump found so far
                    bricks -= pq.poll();
                }
                
                // If bricks become negative, we cannot go further
                if (bricks < 0) return i;
            }
        }
        
        return heights.length - 1;
    }

    /*
     * FAANG Interview Note:
     * This problem is about "Optimization with Constraints". 
     * The greedy insight (Ladders for big, Bricks for small) is the key.
     */
}
