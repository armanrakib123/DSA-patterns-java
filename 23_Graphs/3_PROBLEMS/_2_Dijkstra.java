/**
 * Dijkstra's Algorithm
 * LeetCode 743: Network Delay Time (Medium)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি নেটওয়ার্কের নোডগুলো n (1 থেকে n) পর্যন্ত চিহ্নিত করা আছে। 
 * times[i] = (u, v, w) দেওয়া আছে, যার মানে u থেকে v তে সিগন্যাল যেতে w সময় লাগে।
 * একটি নির্দিষ্ট নোড K থেকে সিগন্যাল পাঠানো হলো। সব নোডে সিগন্যাল পৌঁছাতে মোট কত সময় লাগবে? 
 * (যদি সব নোডে না পৌঁছায় তবে -1 রিটার্ন করতে হবে)।
 * 
 * এপ্রোচ (Dijkstra):
 * ১. প্রথমে একটি Adjacency List তৈরি করব গ্রাফটিকে রিপ্রেজেন্ট করার জন্য।
 * ২. একটি Min Heap (Priority Queue) নেব যা নোডগুলোকে তাদের দূরত্বের ওপর ভিত্তি করে সর্ট করবে।
 * ৩. distances অ্যারে নেব এবং সবাইকে Infinity দিয়ে ফিল (Fill) করব।
 * ৪. অ্যালগরিদম চালিয়ে শর্টেস্ট পাথ বের করব। 
 * ৫. শেষে distances অ্যারের সবচেয়ে বড় ভ্যালুটিই হবে আমাদের উত্তর (কারণ ওই নোডে পৌঁছাতেই সবচেয়ে বেশি সময় লেগেছে)।
 * 
 * Time Complexity: O(E log V) - যেখানে E হলো Edges এবং V হলো Vertices.
 * Space Complexity: O(V + E)
 */





import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _2_Dijkstra {

    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] time : times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // ৩. Min Heap: int[]{node, distance} (distance অনুযায়ী সর্ট হবে)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        minHeap.offer(new int[]{k, 0});

        // ৪. Dijkstra's Algorithm
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int u = current[0];
            int currentDist = current[1];

            // যদি আমরা এই নোডে আরও কম সময়ে আগে পৌঁছে থাকি, তবে এই পুরনো (বড়) দূরত্বটি স্কিপ করব
            if (currentDist > dist[u]) continue;

            // প্রতিবেশীদের চেক করা
            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];
                
                int newDist = currentDist + weight;

                // যদি নতুন দূরত্ব আগের দূরত্বের চেয়ে কম হয় (Relaxation)
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    minHeap.offer(new int[]{v, newDist});
                }
            }
        }

        // ৫. রেজাল্ট বের করা
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // কোনো নোডে পৌঁছানো যায়নি
            }
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }

    public static void main(String[] args) {
        _2_Dijkstra solution = new _2_Dijkstra();
        
        int[][] times = {
            {2, 1, 1},
            {2, 3, 1},
            {3, 4, 1}
        };
        int n = 4;
        int k = 2; // 2 থেকে সিগন্যাল শুরু
        
        System.out.println("Time taken to reach all nodes: " + solution.networkDelayTime(times, n, k)); 
        // Output: 2
    }
}
