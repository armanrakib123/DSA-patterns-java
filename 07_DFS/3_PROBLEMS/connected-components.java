package 

18_DFS_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 323. Number of Connected Components in an Undirected Graph Category:
 * Medium (Graph DFS / Connectivity)
 *
 * Problem: Find the number of connected components in an undirected graph.
 */
public class connected_components {

    /**
     * Approach: DFS on each unvisited node
     *
     * Time Complexity: O(V + E) Space Complexity: O(V + E)
     */
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, adj, visited);
            }
        }

        return count;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }

    /*
     * Software Company Interview Note:
     * This can also be solved with Union-Find (Disjoint Set Union). 
     * DFS is the standard graph-theory approach.
     */
}
