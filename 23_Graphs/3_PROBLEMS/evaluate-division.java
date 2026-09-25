package 29_GRAPH_ALGORITHMS_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 399. Evaluate Division
 * Category: Medium (Graph / DFS / Weighted Edges)
 */
public class evaluate_division {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 1. Build weighted graph
        Map<String, Map<String, Double>> adj = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];
            adj.computeIfAbsent(u, x -> new HashMap<>()).put(v, val);
            adj.computeIfAbsent(v, x -> new HashMap<>()).put(u, 1.0 / val);
        }
        
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            results[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), 1.0, adj, new HashSet<>());
        }
        return results;
    }
    
    private double dfs(String start, String end, double val, Map<String, Map<String, Double>> adj, Set<String> visited) {
        if (!adj.containsKey(start)) return -1.0;
        if (start.equals(end)) return val;
        
        visited.add(start);
        for (Map.Entry<String, Double> neighbor : adj.get(start).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double res = dfs(neighbor.getKey(), end, val * neighbor.getValue(), adj, visited);
                if (res != -1.0) return res;
            }
        }
        return -1.0;
    }
}
