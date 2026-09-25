package 

22_TRIE_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 421. Maximum XOR of Two Numbers in an Array
 * Category: Medium/Hard (Bitwise Trie)
 */
public class maximum_xor_two_numbers {

    class TrieNode {

        TrieNode[] children = new TrieNode[2]; // 0 and 1
    }

    /**
     * Approach: Bitwise Trie (Greedy) For each number, we want to find another
     * number that has the opposite bit at each position (starting from most
     * significant bit) to maximize XOR.
     *
     * Time Complexity: O(N * 31) -> O(N) Space Complexity: O(N * 31)
     */
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();

        // 1. Build Bitwise Trie
        for (int num : nums) {
            TrieNode curr = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (curr.children[bit] == null) {
                    curr.children[bit] = new TrieNode();
                }
                curr = curr.children[bit];
            }
        }

        int maxXor = 0;
        // 2. Query for each number
        for (int num : nums) {
            TrieNode curr = root;
            int currentXor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int targetBit = 1 - bit; // We want the opposite bit

                if (curr.children[targetBit] != null) {
                    currentXor |= (1 << i); // Set bit in XOR result
                    curr = curr.children[targetBit];
                } else {
                    curr = curr.children[bit];
                }
            }
            maxXor = Math.max(maxXor, currentXor);
        }

        return maxXor;
    }

    /*
     * Software Company Interview Note:
     * This is one of the most brilliant uses of a Trie. 
     * It solves a bit manipulation problem using a tree-based strategy.
     */
}
