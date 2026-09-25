package 29_GRAPH_ALGORITHMS_PATTERN.TEMPLATE;

import java.util.*;

/**
 * FAANG Standard Advanced Graph Templates
 */
public class graph_algorithms_template {

    /**
     * Template 1: Dijkstra's Algorithm (Shortest Path)
     */
    public int[] dijkstra(int n, List<List<int[]>> adj, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], d = curr[1];
            
            if (d > dist[u]) continue;
            
            for (int[] edge : adj.get(u)) {
                int v = edge[0], weight = edge[1];
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        return dist;
    }

    /**
     * Template 2: Kahn's Algorithm (Topological Sort)
     */
    public List<Integer> topoSort(int n, List<List<Integer>> adj) {
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int neighbor : adj.get(i)) inDegree[neighbor]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }
        
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            result.add(u);
            for (int v : adj.get(u)) {
                if (--inDegree[v] == 0) q.offer(v);
            }
        }
        
        return result.size() == n ? result : new ArrayList<>(); // Cycle check
    }

    /**
     * Template 3: Prim's Algorithm (MST)
     */
    public int primMST(int n, List<List<int[]>> adj) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] inMST = new boolean[n];
        pq.offer(new int[]{0, 0}); // {node, weight}
        
        int mstWeight = 0;
        int count = 0;
        
        while (!pq.isEmpty() && count < n) {
            int[] curr = pq.poll();
            int u = curr[0], w = curr[1];
            
            if (inMST[u]) continue;
            
            inMST[u] = true;
            mstWeight += w;
            count++;
            
            for (int[] edge : adj.get(u)) {
                if (!inMST[edge[0]]) {
                    pq.offer(edge);
                }
            }
        }
        return mstWeight;
    }
}
