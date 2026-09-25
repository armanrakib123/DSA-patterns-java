package 

18_DFS_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 207. Course Schedule Category: Medium (Graph DFS / Cycle Detection)
 *
 * Problem: Detect if there's a cycle in a directed graph.
 */
public class course_schedule {

    /**
     * Approach: DFS with 3 states (Recursion stack tracking) States: 0:
     * Unvisited 1: Visiting (in current recursion stack) 2: Visited (fully
     * explored)
     *
     * If we encounter a node with state 1, there is a cycle!
     *
     * Time Complexity: O(V + E) Space Complexity: O(V + E)
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }

        int[] state = new int[numCourses]; // 0: unvisited, 1: visiting, 2: visited

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, adj, state)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int node, List<List<Integer>> adj, int[] state) {
        if (state[node] == 1) {
            return true;  // Cycle detected

                }if (state[node] == 2) {
            return false; // Already verified
        }
        state[node] = 1; // Mark as visiting

        for (int neighbor : adj.get(node)) {
            if (hasCycle(neighbor, adj, state)) {
                return true;
            }
        }

        state[node] = 2; // Mark as visited
        return false;
    }

    /*
     * Software Company Interview Note:
     * Cycle detection in directed graphs REQUIRES a "Visiting" state. 
     * A simple boolean visited array is not enough (that only works for undirected graphs).
     */
}
