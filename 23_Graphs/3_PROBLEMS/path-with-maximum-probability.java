package 29_GRAPH_ALGORITHMS_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 1514. Path with Maximum Probability
 * Category: Medium (Dijkstra variation)
 * 
 * Problem: Instead of shortest path (Sum), we want max probability (Product).
 */
public class path_with_maximum_probability {

    /**
     * Approach: Max-Heap Dijkstra
     * 
     * Time Complexity: O(E log V)
     * Space Complexity: O(V + E)
     */
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Object[]>> adj = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            adj.computeIfAbsent(edges[i][0], x -> new ArrayList<>()).add(new Object[]{edges[i][1], succProb[i]});
            adj.computeIfAbsent(edges[i][1], x -> new ArrayList<>()).add(new Object[]{edges[i][0], succProb[i]});
        }
        
        double[] probs = new double[n];
        probs[start] = 1.0;
        
        // Max-heap
        PriorityQueue<Object[]> pq = new PriorityQueue<>((a, b) -> Double.compare((double)b[1], (double)a[1]));
        pq.offer(new Object[]{start, 1.0});
        
        while (!pq.isEmpty()) {
            Object[] curr = pq.poll();
            int u = (int)curr[0];
            double p = (double)curr[1];
            
            if (p < probs[u]) continue;
            if (u == end) return p;
            
            if (!adj.containsKey(u)) continue;
            for (Object[] edge : adj.get(u)) {
                int v = (int)edge[0];
                double w = (double)edge[1];
                if (probs[u] * w > probs[v]) {
                    probs[v] = probs[u] * w;
                    pq.offer(new Object[]{v, probs[v]});
                }
            }
        }
        
        return 0.0;
    }
}
