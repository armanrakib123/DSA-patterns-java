
public class _4_RankOptimization {

    private int[] parent;
    private int[] rank; // ট্রির গভীরতা বা সাইজ ট্র্যাক করার জন্য

    public _4_RankOptimization(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i; // শুরুতে সবাই নিজের Parent
            rank[i] = 1;   // শুরুতে সবার সাইজ ১
        }
    }

    // Find with Path Compression
    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        // Path Compression
        return parent[x] = find(parent[x]);
    }

    // Union by Rank (Size)
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        // যদি তারা আগে থেকেই একই গ্রুপে থাকে, তবে নতুন করে যুক্ত করার কিছু নেই
        // (Cycle Detection এর জন্য এই false রিটার্ন করাটি খুব কাজে দেয়)
        if (rootX == rootY) {
            return false;
        }

        // যার সাইজ বড়, তাকে Parent বানাবো
        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
            rank[rootX] += rank[rootY]; // সাইজ আপডেট
        } else {
            parent[rootX] = rootY;
            rank[rootY] += rank[rootX];
        }

        return true; // সফলভাবে যুক্ত করা হয়েছে
    }

    // Helper method
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    // LeetCode 684: Redundant Connection Example
    public static void main(String[] args) {
        // একটি গ্রাফে সাইকেল তৈরি করা এজটি (Edge) বের করা
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}}; // 2-3 এজটি সাইকেল তৈরি করবে

        _4_RankOptimization dsu = new _4_RankOptimization(edges.length + 1); // 1-based index

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // যদি union false রিটার্ন করে, তার মানে u এবং v আগে থেকেই কানেক্টেড!
            // অর্থাৎ এই এজটি দিলে সাইকেল তৈরি হবে।
            if (!dsu.union(u, v)) {
                System.out.println("Redundant Connection is: [" + u + ", " + v + "]");
                // Output: Redundant Connection is: [2, 3]
            }
        }
    }
}























/**
 * Union Find with Path Compression & Union by Rank
 * (The Ultimate DSU Template)
 * 
 * এটি DSU এর সবচেয়ে অপ্টিমাইজড ভার্সন। Software Company ইন্টারভিউতে সবসময় এই কোডটি লিখতে হবে।
 * 
 * Time Complexity: O(α(N)) - যা প্রায় O(1) এর সমান (Inverse Ackermann function)।
 * Space Complexity: O(N)
 */
