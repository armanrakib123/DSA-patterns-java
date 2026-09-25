import java.util.LinkedList;
import java.util.Queue;


public class GraphBFS {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        // Edge cases: শুরু বা শেষ পয়েন্ট ব্লকড থাকলে
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        // Queue তে int[] রাখব: {row, col, distance}
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1}); // শুরুতেই দূরত্ব ১ (প্রবলেমের রুলস অনুযায়ী)
        grid[0][0] = 1; // Mark as visited

        // ৮টি দিকে যাওয়ার জন্য ডিরেকশন অ্যারে (Row এবং Col এর পরিবর্তন)
        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},       // Up, Down, Left, Right
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}      // Diagonals (TopLeft, TopRight, BottomLeft, BottomRight)
        };

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];

            // টার্গেটে পৌঁছে গেলে
            if (r == n - 1 && c == n - 1) {
                return dist;
            }

            // ৮টি দিকে চেক করা
            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                // বাউন্ডারি চেক এবং রাস্তা ('0') চেক
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                    queue.add(new int[]{newRow, newCol, dist + 1});
                    grid[newRow][newCol] = 1; // Mark as visited
                }
            }
        }

        return -1; // রাস্তা পাওয়া যায়নি
    }

    public static void main(String[] args) {
        GraphBFS solution = new GraphBFS();
        
        int[][] grid = {
            {0, 0, 0},
            {1, 1, 0},
            {1, 1, 0}
        };
        
        System.out.println("Shortest Path Length: " + solution.shortestPathBinaryMatrix(grid)); 
        // Output: 4 (0,0 -> 0,1 -> 0,2 -> 1,2 -> 2,2)
    }
}































/**
 * Grid BFS (Shortest Path) Example
 * LeetCode 1091: Shortest Path in Binary Matrix (Medium)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি n x n বাইনারি ম্যাট্রিক্স দেওয়া আছে। '0' মানে রাস্তা (Clear path) এবং '1' মানে দেয়াল (Blocked)।
 * আপনাকে Top-Left (0,0) থেকে Bottom-Right (n-1, n-1) এ যাওয়ার সবচেয়ে ছোট রাস্তা (Shortest Path) বের করতে হবে।
 * আপনি যেকোনো ৮টি দিকে (উপরে, নিচে, ডানে, বামে এবং কোণাকুণি) চলতে পারবেন।
 * 
 * এপ্রোচ (Approach):
 * ১. Shortest path বের করতে বলেছে, তাই চোখ বন্ধ করে BFS!
 * ২. Queue তে আমরা সেলের কোঅর্ডিনেট (row, col) এবং দূরত্বের (steps) একটি অবজেক্ট বা অ্যারে রাখব।
 * ৩. শুরুতেই চেক করব (0,0) বা (n-1,n-1) এ '1' আছে কি না। থাকলে যাওয়া সম্ভব নয়।
 * ৪. Queue তে (0,0) ঢোকাবো এবং সেটিকে ভিজিটেড মার্ক করে দেব (যেমন '1' বানিয়ে দেব)।
 * ৫. BFS চলতে থাকবে, এবং প্রতি ধাপে ৮টি দিকে যাওয়ার চেষ্টা করব।
 * ৬. টার্গেটে পৌঁছালে distance রিটার্ন করব।
 */