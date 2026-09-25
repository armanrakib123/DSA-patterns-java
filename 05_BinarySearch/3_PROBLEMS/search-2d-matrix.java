package 

07_BINARY_SEARCH_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 74. Search a 2D Matrix
 * Category: Medium
 * 
 * Problem: You are given an m x n integer matrix matrix with the following two properties:
 * 1. Each row is sorted in non-decreasing order.
 * 2. The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 * You must write a solution in O(log(m * n)) time complexity.
 */
public class search_2d_matrix {

    /**
     * Approach: Treat 2D Matrix as 1D Array Because of the two properties, if
     * we flatten the 2D matrix into a 1D array, it will be strictly sorted.
     * However, we don't need to actually flatten it (which takes O(M*N) time
     * and space). We just imagine it's a 1D array of size M * N, and use math
     * to map the 1D index back to the 2D (row, col) coordinates.
     *
     * Mapping formula: row = index / cols col = index % cols
     *
     * Time Complexity: O(log(M * N)) Space Complexity: O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Treat as a 1D array from 0 to (rows * cols - 1)
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Map 1D index 'mid' to 2D coordinates
            int midRow = mid / cols;
            int midCol = mid % cols;

            int midValue = matrix[midRow][midCol];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    /*
     * Software Company Interview Note:
     * The math `row = mid / cols` and `col = mid % cols` is the star of this problem.
     * Make sure you divide and modulo by `cols`, NOT `rows`. (Common mistake).
     */
}
