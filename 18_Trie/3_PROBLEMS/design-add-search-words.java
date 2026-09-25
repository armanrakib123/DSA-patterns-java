package 22_TRIE_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 211. Design Add and Search Words Data Structure
 * Category: Medium (Trie + DFS)
 * 
 * Problem: Design a data structure that supports adding new words and finding if a string matches any 
 * previously added string. The string may contain dots '.' where a dot can match any letter.
 */
public class design_add_search_words {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    public design_add_search_words() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
        return searchInNode(word, 0, root);
    }

    private boolean searchInNode(String word, int index, TrieNode node) {
        if (node == null) return false;
        if (index == word.length()) return node.isEnd;
        
        char c = word.charAt(index);
        if (c != '.') {
            return searchInNode(word, index + 1, node.children[c - 'a']);
        } else {
            // Wildcard: check all possible children
            for (TrieNode child : node.children) {
                if (child != null && searchInNode(word, index + 1, child)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * FAANG Interview Note:
     * This variation introduces DFS with Trie. 
     * Handling the '.' wildcard is a classic recursion challenge.
     */
}
