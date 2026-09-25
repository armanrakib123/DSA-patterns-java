package 

29_GRAPH_ALGORITHMS_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 210. Course Schedule II Category: Medium (Topological Sort / Kahn's
 * Algorithm)
 */
public class course_schedule_ii {

    /**
     * Approach: Kahn's Algorithm (BFS based Topo Sort)
     *
     * Time Complexity: O(V + E) Space Complexity: O(V + E)
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int count = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            result[count++] = u;

            for (int v : adj.get(u)) {
                if (--inDegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        return (count == numCourses) ? result : new int[0];
    }

    /*
     * Software Company Interview Note:
     * This is the "Gold Standard" problem for Topological Sort. 
     * Always check if a cycle exists (if result size < numCourses).
     */
}
