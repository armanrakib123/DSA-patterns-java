package 

22_TRIE_PATTERN.TEMPLATE;

/**
 * Software Company Standard Trie Template
 */
public class trie_template {

    class TrieNode {

        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26]; // For English lowercase letters
            isEndOfWord = false;
        }
    }

    private final TrieNode root;

    public trie_template() {
        root = new TrieNode();
    }

    /**
     * Template 1: Insert a word into the trie Time Complexity: O(L)
     */
    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }

    /**
     * Template 2: Search for a word in the trie Time Complexity: O(L)
     */
    public boolean search(String word) {
        TrieNode node = getLastNode(word);
        return node != null && node.isEndOfWord;
    }

    /**
     * Template 3: Check if any word starts with the given prefix Time
     * Complexity: O(L)
     */
    public boolean startsWith(String prefix) {
        return getLastNode(prefix) != null;
    }

    private TrieNode getLastNode(String s) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                return null;
            }
            curr = curr.children[index];
        }
        return curr;
    }
}
