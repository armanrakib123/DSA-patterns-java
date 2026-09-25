package 

22_TRIE_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 212. Word Search II Category: Hard (Trie + Matrix DFS/Backtracking)
 */
public class word_search_ii {

    class TrieNode {

        TrieNode[] children = new TrieNode[26];
        String word = null; // Store word at leaf for easy retrieval
    }

    public List<String> findWords(char[][] board, String[] words) {
        // 1. Build Trie
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode curr = root;
            for (char c : w.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.word = w;
        }

        List<String> res = new ArrayList<>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> res) {
        char ch = board[r][c];
        if (ch == '#' || node.children[ch - 'a'] == null) {
            return;
        }

        node = node.children[ch - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null; // Avoid duplicates
        }

        board[r][c] = '#'; // Mark visited

        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
                dfs(board, nr, nc, node, res);
            }
        }

        board[r][c] = ch; // Backtrack
    }

    /*
     * Software Company Interview Note:
     * This is a "Boss Level" problem. 
     * Using a Trie to store words makes the backtracking much more efficient 
     * because you can prune branches that don't match any prefix.
     */
}
