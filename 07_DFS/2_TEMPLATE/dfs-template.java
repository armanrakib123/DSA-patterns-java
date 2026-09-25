package 

18_DFS_PATTERN.TEMPLATE;

import java.util.*;

/**
 * Software Company Standard DFS & Backtracking Templates
 */
public class dfs_template {

    /**
     * Template 1: Basic Tree DFS (Pre-order/In-order/Post-order)
     */
    public void treeDFS(TreeNode root) {
        if (root == null) {
            return;
        }

        // Operation BEFORE children (Pre-order)
        System.out.println(root.val);

        treeDFS(root.left);
        treeDFS(root.right);

        // Operation AFTER children (Post-order)
    }

    /**
     * Template 2: Graph DFS (Connectivity / Cycle Detection) Using visited
     * array to prevent infinite loops.
     */
    public void graphDFS(int node, List<List<Integer>> adj, boolean[] visited) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;
        // Process current node

        for (int neighbor : adj.get(node)) {
            graphDFS(neighbor, adj, visited);
        }
    }

    /**
     * Template 3: Matrix DFS (Grid Traversal like Number of Islands)
     */
    public void matrixDFS(int r, int c, int[][] grid, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;

        // 1. Boundary and Condition check
        if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c] || grid[r][c] == 0) {
            return;
        }

        // 2. Mark visited
        visited[r][c] = true;

        // 3. Explore 4-directional neighbors
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : directions) {
            matrixDFS(r + dir[0], c + dir[1], grid, visited);
        }
    }

    /**
     * Template 4: Backtracking (Generating All Possibilities)
     */
    public void backtrack(int start, List<Integer> currentPath, int[] nums) {
        // 1. Goal Check (Base Case)
        // if (currentPath.size() == nums.length) { 
        //     result.add(new ArrayList<>(currentPath)); 
        //     return; 
        // }

        for (int i = start; i < nums.length; i++) {
            // 2. Choose (Make a decision)
            currentPath.add(nums[i]);

            // 3. Explore (Recursive call)
            backtrack(i + 1, currentPath, nums);

            // 4. Un-choose (Backtrack / Undo decision)
            currentPath.remove(currentPath.size() - 1);
        }
    }

    // Helper classes
    class TreeNode {

        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }
}
