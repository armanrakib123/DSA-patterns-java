import java.util.*;

/**
 * 🎯 Topological Sort using Kahn's Algorithm (BFS)
 * লেভেল: Medium (In-degree Logic)
 * 
 * প্রশ্ন: ইন-ডিগ্রি (In-degree) এবং কিউ (Queue) ব্যবহার করে টপোলজিকাল সর্ট করো।
 * 
 * 💡 লজিক:
 * ১. ইন-ডিগ্রি ক্যালকুলেট করা (প্রতিটি নোডে কতগুলো ইনকামিং এজ আছে)।
 * ২. যাদের ইন-ডিগ্রি ০ (কেউ তাদের ওপর ডিপেন্ডেন্ট নয়), তাদের কিউতে রাখা।
 * ৩. কিউ থেকে নোড বের করে তার নেইবারদের ইন-ডিগ্রি ১ কমানো। 
 * ৪. কোনো নেইবারের ইন-ডিগ্রি ০ হলে তাকে কিউতে ঢোকানো।
 * 
 * ⚠️ বিশেষত্ব: যদি রেজাল্ট লিস্টের সাইজ নোড সংখ্যার চেয়ে কম হয়, তার মানে গ্রাফে সাইকেল আছে!
 * 
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 */

public class KahnAlgorithmBFS {

    public List<Integer> topoSort(int v, List<List<Integer>> adj) {
        int[] inDegree = new int[v];
        // ১. ইন-ডিগ্রি বের করো
        for (int i = 0; i < v; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // ২. যাদের ইন-ডিগ্রি ০ তাদের কিউতে নাও
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);

            // ৩. নেইবারদের ইন-ডিগ্রি ১ কমাও
            for (int neighbor : adj.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // ৪. সাইকেল চেক
        if (result.size() != v) {
            System.out.println("Cycle detected! Topological sort not possible.");
            return new ArrayList<>();
        }

        return result;
    }

    public static void main(String[] args) {
        KahnAlgorithmBFS solution = new KahnAlgorithmBFS();
        int v = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());

        adj.get(5).add(2); adj.get(5).add(0);
        adj.get(4).add(0); adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        System.out.println("Topological Sort (Kahn's): " + solution.topoSort(v, adj));
    }
}
