import java.util.*;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        // ১. শুরুতে সব পচা কমলা কিউতে রাখো এবং ভালো কমলার সংখ্যা গোনো
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) return 0;

        int minutes = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // ২. BFS শুরু করো
        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : directions) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    // যদি ইনডেক্স ভ্যালিড হয় এবং কমলাটি ভালো হয়
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // পচিয়ে দাও
                        queue.add(new int[]{nr, nc});
                        freshOranges--;
                    }
                }
            }
        }

        return freshOranges == 0 ? minutes : -1;
    }
    public static void main(String[] args) {
        RottingOranges solution = new RottingOranges();

        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };

        int result = solution.orangesRotting(grid);
        System.out.println("Minutes until all oranges rot: " + result); 
        // Expected Output: 4
    }

    // টাইম কমপ্লেক্সিটি: O(R * C) - প্রতিটি সেল একবার দেখা হয়।
    // স্পেস কমপ্লেক্সিটি: O(R * C) - কিউতে সেল সংখ্যা।
}






















/**
 * 🎯 Problem: Rotting Oranges (LeetCode 994)
 * লেভেল: Medium (Grid BFS)
 * 
 * প্রশ্ন: একটি গ্রিডে কিছু ভালো কমলা (1), পচা কমলা (2) এবং খালি জায়গা (0) আছে। 
 * প্রতি মিনিটে একটি পচা কমলা তার চারপাশের ভালো কমলাগুলোকে পচিয়ে দেয়। 
 * কত সময় পর সব কমলা পচে যাবে? যদি সব পচানো সম্ভব না হয় তবে -1 রিটার্ন করো।
 * 
 * 💡 BFS ইন্টুইশন:
 * এটি একটি মাল্টি-সোর্স BFS। আমরা সব পচা কমলাকে শুরুতে কিউতে রাখব এবং 
 * প্রতি মিনিটে তাদের থেকে ইনফেকশন ছড়িয়ে দেব।
 */