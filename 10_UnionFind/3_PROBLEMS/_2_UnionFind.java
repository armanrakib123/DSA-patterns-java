public class _2_UnionFind {
    private int[] parent;

    // কনস্ট্রাক্টর: শুরুতে সবাই নিজের নিজের Parent (Root)
    public _2_UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    // Find: x এর রুট (বা পরম বস) খুঁজে বের করা
    public int find(int x) {
        // যতক্ষণ সে নিজেই নিজের বস না হচ্ছে
        while (x != parent[x]) {
            x = parent[x];
        }
        return x;
    }

    // Union: x এবং y কে একই গ্রুপে যুক্ত করা
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        // যদি তারা আগে থেকেই একই গ্রুপে না থাকে
        if (rootX != rootY) {
            // x এর রুটকে y এর রুটের সাথে জুড়ে দিই
            parent[rootX] = rootY;
        }
    }

    // Helper: x এবং y একই গ্রুপে আছে কি না চেক করা
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
















/**
 * Basic Union Find (DSU)
 * 
 * এটি একদম বেসিক (এবং আন-অপ্টিমাইজড) Union Find এর ইমপ্লিমেন্টেশন।
 * এখানে কোনো Path Compression বা Union by Rank নেই।
 * 
 * Time Complexity:
 * Find: O(N) - কারণ ট্রি টি একটি লম্বা চেইনের মতো হতে পারে (Linked List)।
 * Union: O(N) - কারণ আগে Find করে রুট বের করতে হয়।
 */