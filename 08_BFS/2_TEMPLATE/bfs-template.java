package 19_BFS_PATTERN.TEMPLATE;

import java.util.*;

/**
 * FAANG Standard BFS Templates (Level Order & Multi-source)
 */
public class bfs_template {

    /**
     * Template 1: Level Order Traversal (Tree)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            int size = q.size(); // Number of nodes in current level
            List<Integer> currentLevel = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                currentLevel.add(node.val);
                
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(currentLevel);
        }
        return res;
    }

    /**
     * Template 2: Multi-source BFS (Grid)
     */
    public int multiSourceBFS(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        
        // 1. Add all sources to the queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) { // 1 is source
                    q.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        
        int steps = 0;
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] d : dirs) {
                    int nr = curr[0] + d[0], nc = curr[1] + d[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            steps++;
        }
        return steps;
    }

    class TreeNode { int val; TreeNode left, right; TreeNode(int x) { val = x; } }
}
