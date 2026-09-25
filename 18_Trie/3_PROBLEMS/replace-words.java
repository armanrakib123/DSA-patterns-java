package 22_TRIE_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 648. Replace Words
 * Category: Medium (Trie Prefix Search)
 */
public class replace_words {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        // 1. Build Trie
        TrieNode root = new TrieNode();
        for (String s : dictionary) {
            TrieNode curr = root;
            for (char c : s.toCharArray()) {
                if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new TrieNode();
                curr = curr.children[c - 'a'];
            }
            curr.word = s;
        }
        
        // 2. Process sentence
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (i > 0) sb.append(" ");
            sb.append(findRoot(words[i], root));
        }
        
        return sb.toString();
    }
    
    private String findRoot(String word, TrieNode root) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null || curr.word != null) break;
            curr = curr.children[c - 'a'];
        }
        return (curr.word != null) ? curr.word : word;
    }

    /*
     * FAANG Interview Note:
     * This problem demonstrates why Tries are superior to HashMaps for 
     * prefix matching. You find the SHORTEST root efficiently.
     */
}
