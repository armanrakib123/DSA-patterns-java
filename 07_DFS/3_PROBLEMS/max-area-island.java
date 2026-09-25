package 

18_DFS_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 695. Max Area of Island
 * Category: Medium (Graph DFS)
 * 
 * Problem: Find the maximum area of an island in a binary grid. 
 * The area of an island is the number of cells with value 1 in the island.
 */
public class max_area_island {

    /**
     * Approach: DFS with area summation Similar to "Number of Islands", but the
     * DFS function returns the total count of connected 1s.
     *
     * Time Complexity: O(M * N) Space Complexity: O(M * N)
     */
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, r, c));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0; // Mark visited

        // Sum current cell + neighbors
        return 1 + dfs(grid, r + 1, c) + dfs(grid, r - 1, c)
                + dfs(grid, r, c + 1) + dfs(grid, r, c - 1);
    }

    /*
     * Software Company Interview Note:
     * This variation tests if you can propagate return values through recursion.
     */
}
