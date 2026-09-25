package 

22_TRIE_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 677. Map Sum Pairs Category: Medium (Trie with state)
 */
public class map_sum_pairs {

    class MapSum {

        class TrieNode {

            TrieNode[] children = new TrieNode[26];
            int sum = 0;
        }

        private TrieNode root;
        private Map<String, Integer> map;

        public MapSum() {
            root = new TrieNode();
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            int diff = val - map.getOrDefault(key, 0);
            map.put(key, val);

            TrieNode curr = root;
            for (char c : key.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
                curr.sum += diff; // Update prefix sum along the path
            }
        }

        public int sum(String prefix) {
            TrieNode curr = root;
            for (char c : prefix.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    return 0;
                }
                curr = curr.children[c - 'a'];
            }
            return curr.sum;
        }
    }

    /*
     * Software Company Interview Note:
     * Storing the sum at each node makes the `sum(prefix)` operation O(L). 
     * This is a "Trade-off" where we spend a bit more time/logic on 
     * insertion to make queries extremely fast.
     */
}
