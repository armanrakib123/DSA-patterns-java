package 29_GRAPH_ALGORITHMS_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 269. Alien Dictionary (Premium)
 * Category: Hard (Topological Sort)
 * 
 * Problem: Given a list of words from an alien language, return the order of characters.
 */
public class alien_dictionary {

    /**
     * Approach: Build DAG from adjacent words and run Topo Sort.
     * 
     * Time Complexity: O(Total letters in words)
     * Space Complexity: O(Number of unique letters)
     */
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        
        // Initialize
        for (String w : words) {
            for (char c : w.toCharArray()) {
                inDegree.put(c, 0);
                adj.put(c, new HashSet<>());
            }
        }
        
        // Build Graph
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i+1];
            // Corner case: "abc" before "ab" is invalid
            if (w1.length() > w2.length() && w1.startsWith(w2)) return "";
            
            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    if (adj.get(c1).add(c2)) {
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        
        // Kahn's Algorithm
        Queue<Character> q = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) q.offer(c);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char curr = q.poll();
            sb.append(curr);
            for (char neighbor : adj.get(curr)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) q.offer(neighbor);
            }
        }
        
        return sb.length() == inDegree.size() ? sb.toString() : "";
    }

    /*
     * FAANG Interview Note:
     * This problem tests your ability to model a real-world scenario 
     * into a graph problem. The mapping of word order to character order 
     * is the key insight.
     */
}
