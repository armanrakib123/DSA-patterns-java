package 29_GRAPH_ALGORITHMS_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 1584. Min Cost to Connect All Points
 * Category: Medium (Minimum Spanning Tree - Prim's or Kruskal's)
 */
public class min_cost_to_connect_all_points {

    /**
     * Approach: Prim's Algorithm
     * 
     * Time Complexity: O(N^2 log N)
     * Space Complexity: O(N^2)
     */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0}); // {node, distance}
        
        boolean[] inMST = new boolean[n];
        int totalCost = 0;
        int connected = 0;
        
        while (connected < n) {
            int[] curr = pq.poll();
            int u = curr[0], d = curr[1];
            
            if (inMST[u]) continue;
            
            inMST[u] = true;
            totalCost += d;
            connected++;
            
            for (int v = 0; v < n; v++) {
                if (!inMST[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0]) + 
                               Math.abs(points[u][1] - points[v][1]);
                    pq.offer(new int[]{v, dist});
                }
            }
        }
        
        return totalCost;
    }

    /*
     * FAANG Interview Note:
     * For dense graphs where edges = V^2, Prim's is often better. 
     * Manually building all edges can take O(V^2) time.
     */
}
