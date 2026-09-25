package 

19_BFS_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 111. Minimum Depth of Binary Tree Category: Easy (BFS Shortest Path)
 *
 * Problem: Find the minimum depth of a binary tree. The minimum depth is the
 * number of nodes along the shortest path from the root node down to the
 * nearest leaf node.
 */
public class min_depth_binary_tree {

    class TreeNode {

        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Approach: BFS (Level Order) BFS is better than DFS here because we find
     * the nearest leaf node level by level. The first leaf node we encounter is
     * guaranteed to be at the minimum depth.
     *
     * Time Complexity: O(N) Space Complexity: O(W) max width
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                // Found a leaf node!
                if (curr.left == null && curr.right == null) {
                    return depth;
                }

                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            depth++;
        }

        return depth;
    }

    /*
     * Software Company Interview Note:
     * While DFS works, BFS is more efficient in cases where the minimum depth 
     * is much smaller than the overall tree height.
     */
}
