public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // যদি ভূমি খুঁজে পাই
                if (grid[r][c] == '1') {
                    islandCount++;
                    dfs(grid, r, c);
                }
            }
        }

        return islandCount;
    }

    private void dfs(char[][] grid, int r, int c) {
        // বাউন্ডারি এবং বেস কেস চেক
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }

        // বর্তমান ভূমিকে '0' বানিয়ে দাও (Visited হিসেবে)
        grid[r][c] = '0';

        // চারদিকে DFS চালাও
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    // টাইম কমপ্লেক্সিটি: O(M * N)
    // স্পেস কমপ্লেক্সিটি: O(M * N) - রিকার্সন স্ট্যাকের জন্য
}




















/**
 * 🎯 Problem: Number of Islands (LeetCode 200)
 * লেভেল: Medium (Classic DFS)
 * 
 * প্রশ্ন: একটি ২ডি গ্রিডে '1' (ভূমি) এবং '0' (জল) আছে। কতগুলো আলাদা দ্বীপ 
 * (কানেক্টেড ভূমি) আছে তা বের করো।
 * 
 * 💡 DFS ইন্টুইশন:
 * যখনই আমরা একটি '1' পাবো, আমরা সেখান থেকে DFS শুরু করব এবং ওই দ্বীপের 
 * সব '1' কে '0' বা অন্য কোনো চিহ্নে বদলে দেব যাতে তারা আবার গণনায় না আসে।
 */