package 

29_GRAPH_ALGORITHMS_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 743. Network Delay Time Category: Medium (Dijkstra)
 *
 * Problem: Find the minimum time it takes for all nodes to receive a signal
 * from a source.
 */
public class network_delay_time {

    /**
     * Approach: Dijkstra's Algorithm Find the shortest path to all nodes and
     * take the maximum.
     *
     * Time Complexity: O(E log V) Space Complexity: O(V + E)
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. Build adjacency list
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] t : times) {
            adj.computeIfAbsent(t[0], x -> new ArrayList<>()).add(new int[]{t[1], t[2]});
        }

        // 2. Dijkstra
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], d = curr[1];

            if (d > dist[u]) {
                continue;
            }
            if (!adj.containsKey(u)) {
                continue;
            }

            for (int[] edge : adj.get(u)) {
                int v = edge[0], w = edge[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        // 3. Find max distance
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // Node not reachable

                        }maxDist = Math.max(maxDist, dist[i]);
        }

        return maxDist;
    }

    /*
     * Software Company Interview Note:
     * This is the standard Dijkstra problem. 
     * Be ready to explain why PriorityQueue is used.
     */
}
