public class _4_DSUImplementation {
    int[] parent;
    int[] rank;
    int numSets;

    public _4_DSUImplementation(int n) {
        parent = new int[n];
        rank = new int[n];
        numSets = n;
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    // ১. Find with Path Compression
    public int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]); // সরাসরি রুটের সাথে কানেক্ট করো
    }

    // ২. Union by Rank
    public boolean union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        if (rootI != rootJ) {
            if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
            } else if (rank[rootI] > rank[rootJ]) {
                parent[rootJ] = rootI;
            } else {
                parent[rootI] = rootJ;
                rank[rootJ]++;
            }
            numSets--; // দুটি সেট মিলে এক হয়ে গেল
            return true;
        }
        return false; // অলরেডি একই সেটে আছে (সাইকেল ডিটেক্ট করা যায় এখান থেকে)
    }

    public int getNumSets() {
        return numSets;
    }
    public static void main(String[] args) {
        _4_DSUImplementation dsu = new _4_DSUImplementation(5);
        dsu.union(0, 1);
        dsu.union(1, 2);
        dsu.union(3, 4);
        dsu.union(2, 3); // এখন সবগুলো একসাথে যুক্ত হয়ে যাবে
        System.out.println("Number of sets: " + dsu.getNumSets()); // Output: 2
    }
    
    // টাইম কমপ্লেক্সিটি: O(alpha(N)) - অত্যন্ত দ্রুত
    // স্পেস কমপ্লেক্সিটি: O(N)
}




















/**
 * 🎯 Concept: Full DSU implementation (Path Compression + Union by Rank)
 * লেভেল: Medium (Data Structure Mastery)
 * 
 * প্রশ্ন: একটি ডাইনামিক গ্রুপিং সিস্টেম তৈরি করো যা ও(১) এর কাছাকাছি সময়ে 
 * Union এবং Find অপারেশন করতে পারে।
 * 
 * 💡 লজিক:
 * ১. Path Compression: find করার সময় প্যারেন্ট আপডেট করা।
 * ২. Union by Rank: ছোট গাছকে বড় গাছের নিচে রাখা।
 */