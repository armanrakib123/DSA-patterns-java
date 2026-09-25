package 29_GRAPH_ALGORITHMS_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 684. Redundant Connection
 * Category: Medium (Graph / Union-Find)
 * 
 * Problem: Find an edge that can be removed so that the resulting graph is a tree.
 */
public class redundant_connection {

    /**
     * Approach: Union-Find
     * For each edge, if the two nodes are already in the same component, 
     * this edge is redundant.
     * 
     * Time Complexity: O(N * α(N)) ≈ O(N)
     * Space Complexity: O(N)
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
        
        for (int[] edge : edges) {
            int root1 = find(parent, edge[0]);
            int root2 = find(parent, edge[1]);
            
            if (root1 == root2) return edge;
            
            parent[root1] = root2; // Union
        }
        
        return new int[0];
    }
    
    private int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent, parent[i]); // Path compression
    }

    /*
     * FAANG Interview Note:
     * Union-Find is the most efficient way to detect cycles in an undirected graph.
     */
}
