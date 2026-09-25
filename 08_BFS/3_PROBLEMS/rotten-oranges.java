package 19_BFS_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 994. Rotting Oranges
 * Multi-source BFS
 */
public class rotten_oranges {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) q.offer(new int[]{r, c});
                else if (grid[r][c] == 1) freshCount++;
            }
        }
        
        if (freshCount == 0) return 0;
        int mins = 0;
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        while (!q.isEmpty()) {
            int size = q.size();
            boolean rotted = false;
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] d : dirs) {
                    int nr = curr[0] + d[0], nc = curr[1] + d[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        freshCount--;
                        q.offer(new int[]{nr, nc});
                        rotted = true;
                    }
                }
            }
            if (rotted) mins++;
        }
        return freshCount == 0 ? mins : -1;
    }
}
