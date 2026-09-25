package 

18_DFS_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 133. Clone Graph Category: Medium (DFS with Hashing)
 */
public class clone_graph {

    class Node {

        public int val;
        public List<Node> neighbors;

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
    }

    private Map<Node, Node> visited = new HashMap<>();

    /**
     * Approach: DFS with Map
     *
     * Time Complexity: O(V + E) Space Complexity: O(V)
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // If already cloned, return the cloned instance
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Clone the node
        Node clone = new Node(node.val);
        visited.put(node, clone);

        // Clone all neighbors recursively
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }

    /*
     * Software Company Interview Note:
     * The recursive DFS solution for Clone Graph is significantly 
     * shorter and cleaner than the BFS version.
     */
}
