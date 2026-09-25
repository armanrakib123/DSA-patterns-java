
import java.util.Arrays;

/**
 * Bellman-Ford Algorithm
 * LeetCode 787: Cheapest Flights Within K Stops (Medium) - Variation
 * 
 * প্রবলেম স্টেটমেন্ট:
 * ডাইকস্ট্রা (Dijkstra) অ্যালগরিদম নেগেটিভ ওজনের রাস্তা (Negative Weights) এর জন্য কাজ করে না। 
 * Bellman-Ford অ্যালগরিদম নেগেটিভ ওজনের রাস্তাতেও শর্টেস্ট পাথ বের করতে পারে। 
 * এটি "Negative Weight Cycle" (এমন সাইকেল যার মোট ওজন নেগেটিভ) ও ডিটেক্ট করতে পারে।
 * 
 * এপ্রোচ (Bellman-Ford):
 * ১. একটি distances অ্যারে নেব এবং সবাইকে Infinity করে দেব। শুরুর নোডের দূরত্ব 0.
 * ২. গ্রাফে যদি V টি নোড থাকে, তবে আমরা (V - 1) বার সবগুলো এজ (Edge) ধরে রিল্যাক্সেশন (Relaxation) করব।
 *    Relaxation মানে: `if (dist[u] + weight < dist[v]) { dist[v] = dist[u] + weight }`
 * ৩. (V - 1) বার করার পর আমরা শর্টেস্ট পাথ পেয়ে যাব।
 * ৪. Negative Cycle Detection: এরপর যদি আরও একবার (V-th বার) লুপ চালাই এবং দেখি দূরত্ব আরও কমছে, 
 *    তার মানে গ্রাফে একটি নেগেটিভ সাইকেল আছে!
 * 
 * Time Complexity: O(V * E)
 * Space Complexity: O(V)
 */
public class _3_BellmanFord {

    // N = number of nodes, edges = {u, v, weight}, src = starting node
    public int[] bellmanFord(int n, int[][] edges, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, 100000000); // Infinity এর বদলে একটি বড় ভ্যালু (ওভারফ্লো এড়াতে)
        dist[src] = 0;

        // V - 1 বার লুপ চালানো
        for (int i = 0; i < n - 1; i++) {
            // প্রতি লুপে সবগুলো এজ রিল্যাক্স করা
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int weight = edge[2];

                if (dist[u] != 100000000 && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // V-th বার চেক করে Negative Cycle Detection
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            if (dist[u] != 100000000 && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return new int[0]; // নেগেটিভ সাইকেল থাকলে শর্টেস্ট পাথ বের করা সম্ভব নয়
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        _3_BellmanFord solution = new _3_BellmanFord();
        
        // 0 -> 1 (Weight: -1), 0 -> 2 (Weight: 4), 1 -> 2 (Weight: 3), 1 -> 3 (Weight: 2), 1 -> 4 (Weight: 2), 3 -> 2 (Weight: 5), 3 -> 1 (Weight: 1), 4 -> 3 (Weight: -3)
        int[][] edges = {
            {0, 1, -1}, {0, 2, 4},
            {1, 2, 3}, {1, 3, 2}, {1, 4, 2},
            {3, 2, 5}, {3, 1, 1},
            {4, 3, -3}
        };
        int n = 5;
        
        int[] distances = solution.bellmanFord(n, edges, 0);
        System.out.println("Distances from source 0: " + Arrays.toString(distances));
        // Output: [0, -1, 2, -2, 1]
    }
}
