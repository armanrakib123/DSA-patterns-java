package 22_TRIE_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 720. Longest Word in Dictionary
 * Category: Easy/Medium (Trie + DFS)
 */
public class longest_word_in_dictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
        String word = "";
    }

    private String result = "";

    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode curr = root;
            for (char c : w.toCharArray()) {
                if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new TrieNode();
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
            curr.word = w;
        }
        
        dfs(root);
        return result;
    }
    
    private void dfs(TrieNode node) {
        // We only explore branches where each prefix is a valid word
        for (TrieNode child : node.children) {
            if (child != null && child.isEnd) {
                if (child.word.length() > result.length()) {
                    result = child.word;
                } else if (child.word.length() == result.length()) {
                    if (child.word.compareTo(result) < 0) result = child.word;
                }
                dfs(child);
            }
        }
    }
}
