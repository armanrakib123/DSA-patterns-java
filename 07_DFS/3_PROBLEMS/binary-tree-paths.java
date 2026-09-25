package 18_DFS_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 257. Binary Tree Paths
 * Category: Easy (Tree DFS / String Backtracking)
 * 
 * Problem: Given the root of a binary tree, return all root-to-leaf paths in any order.
 */
public class binary_tree_paths {

    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Approach: DFS with string building
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) dfs(root, "", result);
        return result;
    }
    
    private void dfs(TreeNode node, String path, List<String> result) {
        // Build the path string
        path += node.val;
        
        // Base Case: Leaf node
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }
        
        // Recurse to children
        if (node.left != null) dfs(node.left, path + "->", result);
        if (node.right != null) dfs(node.right, path + "->", result);
    }

    /*
     * FAANG Interview Note:
     * String concatenation in recursion creates new string objects. 
     * If performance is critical, use `StringBuilder` and backtrack manually.
     */
}
