import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeLevelOrder {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // বর্তমান লেভেলে কতগুলো নোড আছে
            List<Integer> currentLevelNodes = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelNodes.add(currentNode.val);

                // বাম সন্তান থাকলে কিউতে যোগ করো
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                // ডান সন্তান থাকলে কিউতে যোগ করো
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            // বর্তমান লেভেলের লিস্টটি রেজাল্টে যোগ করো
            result.add(currentLevelNodes);
        }

        return result;
    }
    public static void main(String[] args) {
        BinaryTreeLevelOrder solution = new BinaryTreeLevelOrder();

        // একটি উদাহরণ ট্রি তৈরি করা হচ্ছে
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        List<List<Integer>> result = solution.levelOrder(root);
        System.out.println("Level Order Traversal: " + result); 
        // Expected Output: [[1], [2, 3], [4, 5, 6]]
    }

    // টাইম কমপ্লেক্সিটি: O(N) - প্রতিটি নোড একবার করে ভিজিট করা হয়।
    // স্পেস কমপ্লেক্সিটি: O(N) - কিউতে সর্বোচ্চ একটি লেভেলের নোড থাকতে পারে।
}




























/**
 * 🎯 Problem: Binary Tree Level Order Traversal (LeetCode 102)
 * লেভেল: Medium
 * 
 * প্রশ্ন: একটি বাইনারি ট্রির রুট দেওয়া আছে। এর নোডগুলোকে লেভেল অনুযায়ী একটি লিস্টে রিটার্ন করো।
 * 
 * 💡 BFS ইন্টুইশন:
 * যেহেতু লেভেল বাই লেভেল যেতে হবে, তাই BFS ই এখানে সেরা। আমরা একটি কিউ ব্যবহার করব 
 * এবং প্রতিটি লেভেলের নোডগুলোকে আলাদাভাবে প্রসেস করব।
 */