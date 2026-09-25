package 29_GRAPH_ALGORITHMS_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 332. Reconstruct Itinerary
 * Category: Hard (Graph / Hierholzer's Algorithm / Eulerian Path)
 */
public class reconstruct_itinerary {

    /**
     * Approach: Hierholzer's Algorithm (Post-order DFS)
     * Visit edges in lexical order and build the path from back to front.
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> t : tickets) {
            adj.computeIfAbsent(t.get(0), x -> new PriorityQueue<>()).offer(t.get(1));
        }
        
        LinkedList<String> result = new LinkedList<>();
        dfs("JFK", adj, result);
        return result;
    }
    
    private void dfs(String u, Map<String, PriorityQueue<String>> adj, LinkedList<String> result) {
        PriorityQueue<String> neighbors = adj.get(u);
        while (neighbors != null && !neighbors.isEmpty()) {
            dfs(neighbors.poll(), adj, result);
        }
        result.addFirst(u); // Hierholzer's logic: add after exploring all edges
    }

    /*
     * FAANG Interview Note:
     * This is a rare case of Eulerian Path. 
     * The key is to keep going as far as possible and only add to the path 
     * when you hit a dead end.
     */
}
