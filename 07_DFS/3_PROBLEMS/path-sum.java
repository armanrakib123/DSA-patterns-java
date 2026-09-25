package 18_DFS_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 112. Path Sum
 * Category: Easy (Tree DFS)
 * 
 * Problem: Given the root of a binary tree and an integer targetSum, return true if the tree has a 
 * root-to-leaf path such that adding up all the values along the path equals targetSum.
 */
public class path_sum {

    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Approach: DFS (Recursive subtraction)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H) where H is tree height
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        
        // Check if it's a leaf node
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        
        // Subtract current value and check children
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }

    /*
     * FAANG Interview Note:
     * This is the perfect example of DFS base cases. 
     * Always clarify with the interviewer if "path" must start from the root 
     * and end at a leaf.
     */
}
