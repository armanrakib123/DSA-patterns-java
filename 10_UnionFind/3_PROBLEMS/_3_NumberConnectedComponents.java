public class _3_NumberConnectedComponents {

    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int components = n;

        for (int[] edge : edges) {
            if (dsu.union(edge[0], edge[1])) {
                components--;
            }
        }

        return components;
    }

    class DSU {
        int[] parent;
        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        public int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }
        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        _3_NumberConnectedComponents solution = new _3_NumberConnectedComponents();
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(solution.countComponents(n, edges)); // Output: 2
    }

    // টাইম কমপ্লেক্সিটি: O(E * alpha(N))
    // স্পেস কমপ্লেক্সিটি: O(V)
}




















/**
 * 🎯 Problem: Number of Connected Components in an Undirected Graph (LeetCode 323)
 * লেভেল: Medium (DSU Connectivity)
 * 
 * প্রশ্ন: একটি আনডিরেক্টেড গ্রাফে কতগুলো বিচ্ছিন্ন অংশ বা কানেক্টেড কম্পোনেন্ট আছে?
 * 
 * 💡 লজিক:
 * আমরা প্রতিটি এজ প্রসেস করার সময় `union` অপারেশন চালাব। শুরুতে কম্পোনেন্ট সংখ্যা n। 
 * যখনই দুটি নোড সফলভাবে ইউনিয়ন হবে (আগে কানেক্টেড ছিল না), তখনই কম্পোনেন্ট সংখ্যা ১ কমিয়ে দেব।
 */