import java.util.*;

public class _2_AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);
        Map<String, Integer> emailToIndex = new HashMap<>();

        // ১. প্রতিটি ইমেলের জন্য আইডি ম্যাপ করো এবং DSU ইউনিয়ন করো
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (emailToIndex.containsKey(email)) {
                    dsu.union(i, emailToIndex.get(email));
                } else {
                    emailToIndex.put(email, i);
                }
            }
        }

        // ২. রুট আইডির আন্ডারে ইমেলগুলো গ্রুপ করো
        Map<Integer, List<String>> merged = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int root = dsu.find(emailToIndex.get(email));
            merged.computeIfAbsent(root, x -> new ArrayList<>()).add(email);
        }

        // ৩. রেজাল্ট ফরম্যাট করো (সর্টিং সহ)
        List<List<String>> result = new ArrayList<>();
        for (int root : merged.keySet()) {
            List<String> emails = merged.get(root);
            Collections.sort(emails);
            List<String> account = new ArrayList<>();
            account.add(accounts.get(root).get(0)); // নাম
            account.addAll(emails);
            result.add(account);
        }

        return result;
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
        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) parent[rootI] = rootJ;
        }
    }
    public static void main(String[] args) {
        _2_AccountsMerge solution = new _2_AccountsMerge();
        List<List<String>> accounts = Arrays.asList(
            Arrays.asList("John", "john@gmail.com", "johnny@gmail.com"),
            Arrays.asList("John", "john@gmail.com", "johnny@gmail.com"),
            Arrays.asList("Mary", "mary@gmail.com")
        );
        List<List<String>> result = solution.accountsMerge(accounts);
        System.out.println(result);
    }

    // টাইম কমপ্লেক্সিটি: O(N * K log(NK)) - K হলো গড় ইমেল সংখ্যা
    // স্পেস কমপ্লেক্সিটি: O(N * K)
}


















/**
 * 🎯 Problem: Accounts Merge (LeetCode 721)
 * লেভেল: Medium (DSU for Grouping)
 * 
 * প্রশ্ন: কিছু অ্যাকাউন্ট দেওয়া আছে যেখানে নাম এবং একাধিক ইমেল আছে। যদি দুটি 
 * অ্যাকাউন্টে অন্তত একটি ইমেল কমন থাকে, তবে তারা একই ব্যক্তির। তাদের মার্জ করো।
 * 
 * 💡 লজিক:
 * আমরা প্রতিটি ইমেলকে একটি আইডির সাথে ম্যাপ করব এবং DSU ব্যবহার করে কমন ইমেল 
 * থাকা অ্যাকাউন্টগুলোকে কানেক্ট করব।
 */