package 29_GRAPH_ALGORITHMS_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 787. Cheapest Flights Within K Stops
 * Category: Medium (BFS / Dijkstra variation / Bellman-Ford)
 */
public class cheapest_flights_within_k_stops {

    /**
     * Approach: BFS (Level-order)
     * Limit the traversal to K+1 levels.
     * 
     * Time Complexity: O(K * E)
     * Space Complexity: O(V)
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] f : flights) {
            adj.computeIfAbsent(f[0], x -> new ArrayList<>()).add(new int[]{f[1], f[2]});
        }
        
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});
        int stops = 0;
        
        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            int[] nextPrices = Arrays.copyOf(prices, n); // Prevent using updated prices in same level
            
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int u = curr[0], p = curr[1];
                
                if (!adj.containsKey(u)) continue;
                for (int[] edge : adj.get(u)) {
                    int v = edge[0], w = edge[1];
                    if (prices[u] + w < nextPrices[v]) {
                        nextPrices[v] = prices[u] + w;
                        q.offer(new int[]{v, nextPrices[v]});
                    }
                }
            }
            prices = nextPrices;
            stops++;
        }
        
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
