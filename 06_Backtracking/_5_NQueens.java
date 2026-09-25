import java.util.ArrayList;
import java.util.List;

public class _5_NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        backtrack(result, board, 0, n);
        return result;
    }

    private void backtrack(List<List<String>> result, char[][] board, int row, int n) {
        if (row == n) {
            result.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            
            if (isSafe(board, row, col, n)) {
                
                board[row][col] = 'Q';
                
                backtrack(result, board, row + 1, n);
                
                board[row][col] = '.';
            }
        }
    }


    private boolean isSafe(char[][] board, int row, int col, int n) {
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

    private List<String> constructBoard(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            list.add(new String(board[i]));
        }
        return list;
    }
}

























/**
 * N-Queens Example (Advanced Backtracking)
 * LeetCode 51: N-Queens (Hard)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি N x N চেস বোর্ডে (Chessboard) N সংখ্যক রানিকে (Queen) এমনভাবে বসাতে হবে যেন 
 * তারা একে অপরকে আক্রমণ (Attack) করতে না পারে।
 * রানি সোজাসুজি (Row/Col) এবং কোনাকুনি (Diagonal) আক্রমণ করতে পারে।
 * 
 * এপ্রোচ (Approach):
 * ১. আমরা রো (Row) ধরে ধরে এগোব। প্রতি রো-তে একটি করে রানি বসানোর চেষ্টা করব।
 * ২. কলাম (Col) অনুযায়ী চেক করব যে ওই ঘরে রানি বসালে সে নিরাপদ (Safe) কি না।
 * ৩. নিরাপদ হলে রানি বসাবো (Choose), পরের রো-তে যাব (Explore), এবং ফিরে এসে রানি তুলে নেব (Un-choose)।
 */