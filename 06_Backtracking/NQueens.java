import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        backtrack(res, board, 0, n);
        return res;
    }

    private void backtrack(List<List<String>> res, char[][] board, int row, int n) {
      
        if (row == n) {
            res.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {

            if (isValid(board, row, col, n)) {
               
                board[row][col] = 'Q';
                
                backtrack(res, board, row + 1, n);
                
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col, int n) {
     
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        NQueens solution = new NQueens();
        int n = 4;
        List<List<String>> result = solution.solveNQueens(n);
        
        System.out.println("Solutions for 4-Queens:");
        for (List<String> board : result) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println("----------");
        }
    }
}

























/**
 * 🎯 Problem 3: N-Queens (LeetCode 51)
 * লেভেল: Hard (The Boss of Backtracking)
 * 
 * প্রশ্ন: একটি n x n দাবা বোর্ডে n-টি কুইন (Queen) এমনভাবে বসাতে হবে যেন কেউ কাউকে আক্রমণ করতে না পারে। 
 * (অর্থাৎ একই রো, কলাম বা ডায়াগোনালে একাধিক কুইন থাকতে পারবে না)। সব সম্ভাব্য সমাধান রিটার্ন করতে হবে।
 * 
 * 💡 ব্যাকট্র্যাকিং লজিক:
 * আমরা রো (Row) অনুযায়ী এক এক করে আগাব। প্রতিটি রো-তে আমরা চেক করব কোন কলামে কুইন বসালে তা সেফ (Safe) থাকে।
 * 
 * 🚀 সেফটি চেক করার স্মার্ট উপায়:
 * ১. Column: একটি কলামে কি অলরেডি কুইন আছে?
 * ২. Positive Diagonal (r + c): এই ভ্যালুটি প্রতিটি ডায়াগোনালের জন্য ইউনিক থাকে।
 * ৩. Negative Diagonal (r - c): এই ভ্যালুটি অন্য ডায়াগোনালের জন্য ইউনিক থাকে।
 * 
 * Time Complexity: O(N!)
 * Space Complexity: O(N^2) (বোর্ডের জন্য)
 */