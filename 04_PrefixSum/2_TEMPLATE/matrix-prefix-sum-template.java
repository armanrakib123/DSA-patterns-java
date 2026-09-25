package 

03_PREFIX_SUM_PATTERN.TEMPLATE;

/**
 * Software Company Standard 2D Prefix Sum Template
 * Used for fast 2D matrix region sum queries.
 */
public class matrix_prefix_sum_template {

    private long[][] prefix;

    /**
     * Preprocesses the 2D matrix into a 2D prefix sum array. Time Complexity:
     * O(R * C) Space Complexity: O(R * C)
     *
     * @param matrix Original 2D grid
     */
    public matrix_prefix_sum_template(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // 1-based indexing to avoid out-of-bounds checks
        prefix = new long[rows + 1][cols + 1];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Current cell sum = current element + top sum + left sum - top-left diagonal sum (overlapping)
                prefix[r + 1][c + 1] = matrix[r][c]
                        + prefix[r][c + 1]
                        + prefix[r + 1][c]
                        - prefix[r][c];
            }
        }
    }

    /**
     * Calculates the sum of a rectangular region. Time Complexity: O(1)
     *
     * @param row1 Top-left row index
     * @param col1 Top-left column index
     * @param row2 Bottom-right row index
     * @param col2 Bottom-right column index
     * @return Sum of the elements in the region
     */
    public long sumRegion(int row1, int col1, int row2, int col2) {
        // Adjust indices for 1-based prefix array
        // Total area - Top area - Left area + Top-Left area (added back as it was subtracted twice)
        return prefix[row2 + 1][col2 + 1]
                - prefix[row1][col2 + 1]
                - prefix[row2 + 1][col1]
                + prefix[row1][col1];
    }
}
