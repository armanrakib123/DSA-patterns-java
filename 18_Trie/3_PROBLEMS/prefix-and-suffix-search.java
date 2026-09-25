package 22_TRIE_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 745. Prefix and Suffix Search
 * Category: Hard (Advanced Trie Design)
 * 
 * Problem: Design a special trie that searches for a word by a prefix and a suffix.
 */
public class prefix_and_suffix_search {

    class WordFilter {
        class TrieNode {
            TrieNode[] children = new TrieNode[27]; // 26 letters + '{' (for separator)
            int weight = 0;
        }

        private TrieNode root;

        public WordFilter(String[] words) {
            root = new TrieNode();
            for (int i = 0; i < words.length; i++) {
                String s = words[i];
                // Insert all possible suffix + { + prefix combinations
                // Example: apple -> e{apple, le{apple, ple{apple, ...
                for (int j = 0; j <= s.length(); j++) {
                    insert(s.substring(j) + "{" + s, i);
                }
            }
        }

        private void insert(String s, int weight) {
            TrieNode curr = root;
            for (char c : s.toCharArray()) {
                int index = c - 'a';
                if (curr.children[index] == null) curr.children[index] = new TrieNode();
                curr = curr.children[index];
                curr.weight = weight;
            }
        }

        public int f(String prefix, String suffix) {
            TrieNode curr = root;
            for (char c : (suffix + "{" + prefix).toCharArray()) {
                if (curr.children[c - 'a'] == null) return -1;
                curr = curr.children[c - 'a'];
            }
            return curr.weight;
        }
    }

    /*
     * FAANG Interview Note:
     * This "Suffix + Separator + Prefix" trick is the key to solving 
     * complex two-way prefix/suffix matches in O(L) time.
     */
}
