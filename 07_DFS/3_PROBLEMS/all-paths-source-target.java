package 

18_DFS_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 797. All Paths From Source to Target Category: Medium (Backtracking
 * on DAG)
 *
 * Problem: Given a directed acyclic graph (DAG) of n nodes, find all possible
 * paths from node 0 to node n - 1.
 */
public class all_paths_source_target {

    /**
     * Approach: Backtracking (DFS)
     *
     * Time Complexity: O(2^N * N) Space Complexity: O(N)
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, graph, path, result);
        return result;
    }

    private void dfs(int node, int[][] graph, List<Integer> path, List<List<Integer>> result) {
        // Base case: Reached the target
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int neighbor : graph[node]) {
            // 1. Choose
            path.add(neighbor);
            // 2. Explore
            dfs(neighbor, graph, path, result);
            // 3. Un-choose (Backtrack)
            path.remove(path.size() - 1);
        }
    }

    /*
     * Software Company Interview Note:
     * Since this is a DAG, we don't need a visited array to prevent cycles. 
     * However, the "Choose-Explore-Backtrack" pattern is still necessary 
     * to explore all paths.
     */
}
