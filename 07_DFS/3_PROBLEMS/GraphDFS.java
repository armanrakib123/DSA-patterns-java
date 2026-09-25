public class GraphDFS {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // গ্রিডের প্রতিটি সেলে যাব
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                
                // যদি '1' পাই, তার মানে নতুন দ্বীপ পেয়েছি
                if (grid[i][j] == '1') {
                    numIslands++;
                    
                    // DFS কল করে এই দ্বীপের পুরোটা '0' বানিয়ে দিই (Sink the island)
                    dfs(grid, i, j);
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Base case: বাউন্ডারি চেক এবং '0' চেক
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') {
            return;
        }

        // বর্তমান সেলকে '0' (Water) বানিয়ে দিই (Marking as visited)
        grid[r][c] = '0';

        // ৪ দিকে (Up, Down, Left, Right) DFS কল করি
        dfs(grid, r - 1, c); // Up
        dfs(grid, r + 1, c); // Down
        dfs(grid, r, c - 1); // Left
        dfs(grid, r, c + 1); // Right
    }

    public static void main(String[] args) {
        GraphDFS solution = new GraphDFS();
        
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        
        System.out.println("Number of Islands: " + solution.numIslands(grid)); 
        // Output: 3 (উপরের বামে একটি বড়, মাঝখানে একটি ছোট, নিচে ডানে একটি ছোট দ্বীপ)
    }
}

























/**
 * Grid/Graph DFS Example
 * LeetCode 200: Number of Islands (Medium) - FAANG Favorite
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি m x n 2D grid দেওয়া আছে, যেখানে '1' মানে ভূমি (Land) এবং '0' মানে পানি (Water)।
 * আপনাকে বলতে হবে কতগুলো দ্বীপ (Island) আছে।
 * একটি দ্বীপ তৈরি হয় পাশাপাশি (উপরে, নিচে, ডানে, বামে) সংযুক্ত '1' গুলো নিয়ে।
 * 
 * এপ্রোচ (Approach):
 * ১. আমরা পুরো গ্রিডের প্রতিটি সেল লুপ দিয়ে চেক করব।
 * ২. যখনই কোনো '1' (ভূমি) পাব, তার মানে আমরা একটি নতুন দ্বীপ পেয়েছি (count++)।
 * ৩. এরপর ওই সেল থেকে আমরা Grid DFS শুরু করব।
 * ৪. DFS এর কাজ হবে ওই দ্বীপের সাথে সংযুক্ত সব '1' কে ভিজিট করে '0' বানিয়ে দেওয়া 
 *    (যাতে পরবর্তীতে লুপে আবার ওই একই দ্বীপে ঢুকে না পড়ি)।
 * ৫. সবশেষে count রিটার্ন করব।
 * 
 * Time Complexity: O(M * N) - কারণ আমরা প্রতিটি সেল সর্বোচ্চ একবার ভিজিট করছি।
 * Space Complexity: O(M * N) - সবচেয়ে খারাপ ক্ষেত্রে (সবই ভূমি হলে) Call Stack এর সাইজ।
 */