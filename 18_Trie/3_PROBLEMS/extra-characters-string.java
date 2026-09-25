package 

22_TRIE_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 2707. Extra Characters in a String Category: Medium (Trie + DP)
 */
public class extra_characters_string {

    class TrieNode {

        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    public int minExtraChar(String s, String[] dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            // Case 1: Current character is extra
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);

            // Case 2: Check all words in trie starting from index i
            TrieNode curr = root;
            for (int j = i; j < n; j++) {
                if (curr.children[s.charAt(j) - 'a'] == null) {
                    break;
                }
                curr = curr.children[s.charAt(j) - 'a'];
                if (curr.isEnd) {
                    dp[j + 1] = Math.min(dp[j + 1], dp[i]);
                }
            }
        }

        return dp[n];
    }

    /*
     * Software Company Interview Note:
     * This problem combines DP with Trie optimization. 
     * The Trie allows us to find all dictionary words starting at s[i] in O(L).
     */
}
