public class _3_PathCompression {
    private int[] parent;

    public _3_PathCompression(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    // Find with Path Compression
    public int find(int x) {
        if (x == parent[x]) {
            return x; // বেস কেস: সে নিজেই নিজের বস
        }
        
        // রিকার্সন করে পরম বস খুঁজে আনি এবং 
        // ফেরার পথে সরাসরি সবার parent হিসেবে পরম বসকে সেট করে দিই! (এটাই ম্যাজিক)
        parent[x] = find(parent[x]);
        
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }
}





















/**
 * Union Find with Path Compression
 * 
 * এটি বেসিক DSU এর চেয়ে অনেক ফাস্ট। এখানে শুধু Find মেথডে একটি লাইন যোগ করে 
 * Path Compression করা হয়েছে।
 * 
 * Time Complexity: O(log N) গড়ে (Amortized)।
 */