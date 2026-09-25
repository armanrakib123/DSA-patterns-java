package 19_BFS_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 1091. Shortest Path in Binary Matrix
 */
public class shortest_path_binary_matrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        grid[0][0] = 1;
        
        int steps = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                if (curr[0] == n - 1 && curr[1] == n - 1) return steps;
                
                for (int[] d : dirs) {
                    int nr = curr[0] + d[0], nc = curr[1] + d[1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                        grid[nr][nc] = 1;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
