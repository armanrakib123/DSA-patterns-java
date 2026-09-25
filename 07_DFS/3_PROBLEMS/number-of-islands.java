package 18_DFS_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 200. Number of Islands
 * Category: Medium (Graph DFS / Connectivity)
 * 
 * Problem: Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), 
 * return the number of islands.
 */
public class number_of_islands {

    /**
     * Approach: DFS (Recursive sink)
     * When we find a '1', we increment the island count and visit all its 
     * connected land nodes using DFS, marking them as '0' (visited).
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N) in the worst case (recursion stack)
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    dfs(grid, r, c);
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Base Case: Boundary check and water check
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == '0') {
            return;
        }
        
        // Mark as visited (sink the land)
        grid[r][c] = '0';
        
        // Visit all 4 neighbors
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    /*
     * FAANG Interview Note:
     * DFS is often easier to write for matrix problems than BFS. 
     * However, be careful about the "StackOverflowError" if the grid is massive.
     */
}
