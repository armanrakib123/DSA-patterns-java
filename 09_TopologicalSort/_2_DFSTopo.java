import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

 public class _2_DFSTopo {

    public List<Integer> topologicalSortDFS(int numCourses, List<List<Integer>> graph) {
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited, stack);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, stack);
            }
        }

        stack.push(node);
    }

    public static void main(String[] args) {
        _2_DFSTopo solution = new _2_DFSTopo();
        
        int numNodes = 4;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<>());
        }
        
        // গ্রাফ: 0 -> 1, 0 -> 2, 1 -> 3, 2 -> 3
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(3);
        
        System.out.println("Topological Sort (DFS): " + solution.topologicalSortDFS(numNodes, graph)); 
        // Output হতে পারে: [0, 2, 1, 3] অথবা [0, 1, 2, 3]
    }
}




















/**
 * DFS Based Topological Sort
 * 
 * প্রবলেম: একটি Directed Acyclic Graph (DAG) এর টপোলজিক্যাল সর্ট বের করা।
 * 
 * এপ্রোচ (Approach):
 * ১. একটি DFS ফাংশন লিখব যা নোড থেকে তার সব প্রতিবেশীর কাছে গভীরে (Depth) যাবে।
 * ২. যখন একটি নোডের আর কোনো প্রতিবেশী থাকবে না (বা সবার কাজ শেষ), 
 *    তখন আমরা ওই নোডটিকে একটি Stack (স্ট্যাক) এ Push করব।
 * ৩. এর মানে হলো, যাদের ওপর কেউ নির্ভরশীল নয়, তারা সবার নিচে থাকবে। 
 *    আর যারা সবার আগে (root), তারা স্ট্যাকের ওপরে থাকবে।
 * ৪. শেষে স্ট্যাক থেকে পপ (Pop) করলেই আমরা Topological Order পেয়ে যাব!
 * 
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 */