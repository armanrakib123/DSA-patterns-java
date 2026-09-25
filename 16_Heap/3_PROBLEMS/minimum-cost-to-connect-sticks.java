package 23_HEAP_PRIORITY_QUEUE_PATTERN.TOP_10_PROBLEMS;

import java.util.PriorityQueue;

/**
 * LeetCode 1167. Minimum Cost to Connect Sticks
 * Category: Medium (Greedy + Min-Heap)
 * 
 * Problem: You have some sticks with positive integer lengths. 
 * You can connect any two sticks of lengths x and y into one stick by paying a cost of x + y. 
 * Find the minimum cost to connect all sticks into one.
 */
public class minimum_cost_to_connect_sticks {

    /**
     * Approach: Greedy (Always connect the two shortest sticks)
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(N)
     */
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : sticks) pq.offer(s);
        
        int totalCost = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int cost = first + second;
            totalCost += cost;
            pq.offer(cost);
        }
        
        return totalCost;
    }

    /*
     * FAANG Interview Note:
     * This is a classic Huffman Coding style problem. 
     * The greedy choice (connecting shortest) leads to the global optimum.
     */
}
