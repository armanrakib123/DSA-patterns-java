package 

18_DFS_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 733. Flood Fill
 * Category: Easy (Matrix DFS)
 * 
 * Problem: An image is represented by an m x n integer grid image where image[i][j] 
 * represents the pixel value of the image. Perform a flood fill.
 */
public class flood_fill {

    /**
     * Approach: DFS traversal
     *
     * Time Complexity: O(N) where N is number of pixels Space Complexity: O(N)
     * for recursion stack
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        if (initialColor != color) {
            dfs(image, sr, sc, initialColor, color);
        }
        return image;
    }

    private void dfs(int[][] image, int r, int c, int initialColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != initialColor) {
            return;
        }

        image[r][c] = newColor;

        dfs(image, r + 1, c, initialColor, newColor);
        dfs(image, r - 1, c, initialColor, newColor);
        dfs(image, r, c + 1, initialColor, newColor);
        dfs(image, r, c - 1, initialColor, newColor);
    }

    /*
     * Software Company Interview Note:
     * Always add the check `initialColor != color` to prevent infinite recursion 
     * when the starting pixel already has the target color.
     */
}
