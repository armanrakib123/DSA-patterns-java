
/**
 * Floyd-Warshall Algorithm
 * 
 * প্রবলেম স্টেটমেন্ট:
 * ডাইকস্ট্রা বা বেলম্যান-ফোর্ড একটি নির্দিষ্ট নোড (Single Source) থেকে বাকি সব নোডের দূরত্ব বের করে।
 * কিন্তু যদি আপনাকে বলা হয় "যেকোনো নোড থেকে যেকোনো নোডের (All-Pairs) শর্টেস্ট পাথ বের করো"?
 * তখন আমরা Floyd-Warshall অ্যালগরিদম ব্যবহার করি।
 * 
 * এপ্রোচ (Dynamic Programming):
 * ১. এটি একটি 2D Matrix DP অ্যাপ্রোচ।
 * ২. `dist[i][j]` মানে হলো i থেকে j তে যাওয়ার শর্টেস্ট পাথ।
 * ৩. আমরা ৩টি Nested Loop চালাব: 
 *    - k (মাঝখানের নোড বা Intermediate node)
 *    - i (শুরুর নোড)
 *    - j (শেষের নোড)
 * ৪. রুল: `dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])`
 *    অর্থাৎ, i থেকে j তে সরাসরি যাওয়ার চেয়ে যদি k হয়ে (ভায়া হয়ে) গেলে খরচ কম হয়, তবে সেটি নেব।
 * 
 * Time Complexity: O(V^3) - তিনটি লুপের কারণে এটি বেশ স্লো, তবে ছোট গ্রাফের (V <= 400) জন্য দারুণ কাজ করে।
 * Space Complexity: O(V^2) - 2D Matrix এর জন্য।
 */
public class _4_FloydWarshall {

    public void floydWarshall(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];
        int INF = 100000; // Infinity

        // গ্রাফটিকে dist অ্যারেতে কপি করা
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // ৩টি লুপ (k হলো intermediate vertex)
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    // যদি i থেকে k এবং k থেকে j এর রাস্তা থাকে (INF না হয়)
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        // সরাসরি যাওয়ার চেয়ে ভায়া হয়ে গেলে কম লাগে কি না
                        if (dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }

        // প্রিন্ট রেজাল্ট
        printSolution(dist, V, INF);
    }

    private void printSolution(int[][] dist, int V, int INF) {
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        _4_FloydWarshall solution = new _4_FloydWarshall();
        
        int INF = 100000;
        int[][] graph = { 
            {0,   5,  INF, 10},
            {INF, 0,   3, INF},
            {INF, INF, 0,   1},
            {INF, INF, INF, 0}
        };
        
        solution.floydWarshall(graph);
    }
}
