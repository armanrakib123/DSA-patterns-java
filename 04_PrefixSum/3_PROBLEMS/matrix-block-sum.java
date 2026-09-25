package 03_PREFIX_SUM_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 1314. Matrix Block Sum
 * Category: Medium (Computer Vision / Image Processing foundation)
 * 
 * Problem: Given an m x n matrix mat and an integer k, return a matrix answer where each answer[i][j] 
 * is the sum of all elements mat[r][c] for:
 * i - k <= r <= i + k,
 * j - k <= c <= j + k,
 * and (r, c) is a valid position in the matrix.
 */
public class matrix_block_sum {

    /**
     * Approach: 2D Prefix Sum Array
     * To avoid summing the block repeatedly, we precompute a 2D prefix sum array.
     * Then for each cell, we define the boundary of the block and use the 2D range sum formula.
     * 
     * Time Complexity: O(M * N) for building prefix sum + O(M * N) for answers = O(M * N)
     * Space Complexity: O(M * N) for the prefix sum array
     */
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        // Step 1: Build 1-based 2D Prefix Sum array
        int[][] prefix = new int[m + 1][n + 1];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Formula: current element + top sum + left sum - top-left overlapping sum
                prefix[i + 1][j + 1] = mat[i][j] + prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j];
            }
        }
        
        // Step 2: Calculate answer for each block
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Determine boundaries ensuring we don't go out of bounds
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);
                
                // Adjust for 1-based indexing
                r1++; c1++; r2++; c2++;
                
                // Formula: Total block - top unneeded - left unneeded + top-left overlapping
                answer[i][j] = prefix[r2][c2] - prefix[r1 - 1][c2] - prefix[r2][c1 - 1] + prefix[r1 - 1][c1 - 1];
            }
        }
        
        return answer;
    }

    /*
     * FAANG Interview Note:
     * This is a direct application of the 2D Prefix Sum template.
     * It's crucial to comfortably handle the boundary checks (Math.max and Math.min) 
     * without making off-by-one errors. 1-based indexing saves you from nasty OutOfBounds exceptions.
     */
}
