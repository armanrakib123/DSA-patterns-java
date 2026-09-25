package 18_DFS_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 79. Word Search
 * Category: Medium (Backtracking / Matrix DFS)
 * 
 * Problem: Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 */
public class word_search {

    /**
     * Approach: Backtracking (DFS with path undoing)
     * 
     * Time Complexity: O(N * 3^L) where N is cells, L is word length.
     * Space Complexity: O(L)
     */
    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(board, r, c, word, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int r, int c, String word, int index) {
        // Base Case: Word found
        if (index == word.length()) return true;
        
        // Boundary and character match check
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }
        
        // 1. Choose: Mark as visited (using a temporary character)
        char temp = board[r][c];
        board[r][c] = '#'; 
        
        // 2. Explore: 4 directions
        boolean found = dfs(board, r + 1, c, word, index + 1) ||
                        dfs(board, r - 1, c, word, index + 1) ||
                        dfs(board, r, c + 1, word, index + 1) ||
                        dfs(board, r, c - 1, word, index + 1);
        
        // 3. Un-choose: Backtrack (Restore character)
        board[r][c] = temp;
        
        return found;
    }

    /*
     * FAANG Interview Note:
     * This is a quintessential backtracking problem. 
     * The `board[r][c] = '#'` trick avoids using an extra boolean array, 
     * saving O(M*N) space.
     */
}
