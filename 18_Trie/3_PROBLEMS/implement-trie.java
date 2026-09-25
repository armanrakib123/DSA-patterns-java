package 22_TRIE_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 208. Implement Trie (Prefix Tree)
 * Category: Medium (Fundamental Trie)
 */
public class implement_trie {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    public implement_trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private TrieNode find(String s) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            if (curr.children[c - 'a'] == null) return null;
            curr = curr.children[c - 'a'];
        }
        return curr;
    }

    /*
     * FAANG Interview Note:
     * This is the baseline problem for Trie. 
     * Practice writing this until it becomes muscle memory.
     */
}
