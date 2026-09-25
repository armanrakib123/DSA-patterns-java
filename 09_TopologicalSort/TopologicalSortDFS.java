import java.util.*;

/**
 * 🎯 Topological Sort using DFS
 * লেভেল: Medium (Postorder Logic)
 * 
 * প্রশ্ন: একটি DAG (Directed Acyclic Graph) দেওয়া আছে। DFS ব্যবহার করে এর টপোলজিকাল সর্ট বের করো।
 * 
 * 💡 লজিক:
 * আমরা DFS চালিয়ে প্রতিটি নোডের সব নেইবারদের ভিজিট করব। যখন একটি নোডের আর কোনো 
 * ভিজিট করার মতো নেইবার থাকবে না, তার মানে ওই নোডটি কাজের ধারাক্রম অনুযায়ী সবার শেষে আসবে। 
 * তাই আমরা তাকে একটি স্ট্যাকে (Stack) রাখব এবং শেষে স্ট্যাকটি পপ করে রেজাল্ট দেখব।
 * 
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 */

public class TopologicalSortDFS {

    public List<Integer> topoSort(int v, List<List<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private void dfs(int curr, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[curr] = true;

        for (int neighbor : adj.get(curr)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, stack);
            }
        }

        // সব নেইবার ভিজিট করা শেষ হলে স্ট্যাকে পুশ করো
        stack.push(curr);
    }

    public static void main(String[] args) {
        TopologicalSortDFS solution = new TopologicalSortDFS();
        int v = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());

        adj.get(5).add(2); adj.get(5).add(0);
        adj.get(4).add(0); adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        System.out.println("Topological Sort (DFS): " + solution.topoSort(v, adj));
        // Expected: [5, 4, 2, 3, 1, 0] (একধিক সঠিক উত্তর হতে পারে)
    }
}
