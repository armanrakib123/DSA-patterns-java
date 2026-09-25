import java.util.LinkedList;
import java.util.Queue;


public class MultiSourceBFS {

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // স্টেপ ১: Queue তে সবগুলো পচা কমলা ঢোকানো এবং ভালো কমলা গুনে রাখা
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // যদি শুরুতেই কোনো ভালো কমলা না থাকে
        if (freshCount == 0) return 0;

        int minutes = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right

        // স্টেপ ২: BFS চালানো
        while (!queue.isEmpty() && freshCount > 0) { // freshCount > 0 চেক করা জরুরি, নাহলে শেষে অযথাই ১ মিনিট বেড়ে যায়
            int levelSize = queue.size();

            // বর্তমান লেভেলের (বা মিনিটের) সব পচা কমলা প্রসেস করা
            for (int i = 0; i < levelSize; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                // চারপাশের কমলা চেক করা
                for (int[] dir : directions) {
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];

                    // যদি ভালো কমলা ('1') পাওয়া যায়
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;  // পচিয়ে দিলাম (Mark as visited)
                        queue.add(new int[]{newRow, newCol}); // Queue তে দিলাম যাতে সে পরের মিনিটে অন্য কাউকে পচাতে পারে
                        freshCount--; // একটি ভালো কমলা কমে গেল
                    }
                }
            }
            minutes++;
        }

        // যদি এখনো ভালো কমলা বেঁচে থাকে
        return freshCount == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        MultiSourceBFS solution = new MultiSourceBFS();
        
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        
        System.out.println("Minutes to rot all oranges: " + solution.orangesRotting(grid)); 
        // Output: 4
    }
}































/**
 * Multi-Source BFS Example
 * LeetCode 994: Rotting Oranges (Medium) - Amazon Favorite
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি m x n গ্রিড দেওয়া আছে যেখানে:
 * 0 = খালি জায়গা, 1 = ভালো কমলা (Fresh orange), 2 = পচা কমলা (Rotten orange)।
 * প্রতি মিনিটে একটি পচা কমলা তার চারপাশের (উপরে, নিচে, ডানে, বামে) ভালো কমলাকে পচিয়ে দেয়।
 * সব কমলা পচতে কত মিনিট সময় লাগবে? যদি কোনো ভালো কমলা এমন জায়গায় থাকে যেখানে পচানো সম্ভব নয়, তবে -1 রিটার্ন করুন।
 * 
 * এপ্রোচ (Approach):
 * এটি একটি ক্লাসিক Multi-Source BFS প্রবলেম, কারণ শুরুতে একাধিক পচা কমলা (2) থাকতে পারে 
 * এবং তারা সবাই একসাথে পচানো শুরু করবে।
 * ১. প্রথমে পুরো গ্রিড স্ক্যান করব। 
 *    - যতগুলো '2' আছে, তাদের সবাইকে Queue তে ঢোকাবো (এগুলো হলো আমাদের level 0)।
 *    - '1' এর সংখ্যা (freshCount) গুনে রাখব, যেন শেষে চেক করতে পারি সব পচেছে কি না।
 * ২. Queue থেকে বের করে BFS চালাব এবং চারপাশে '1' পেলে তাকে '2' বানিয়ে Queue তে ঢোকাবো এবং freshCount কমাব।
 * ৩. প্রতি লেভেল শেষ হলে মিনিট (minutes) ১ করে বাড়াব।
 * 
 * Time Complexity: O(M * N)
 * Space Complexity: O(M * N)
 */