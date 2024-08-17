package solutions.pack7_Recursion;

// time complexity: O(m*n)
public class GridPaths {
    public static int numberOfPaths(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Edge case: start or end is an obstacle
        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[rows][cols];

        // Initial position
        dp[0][0] = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0) dp[i][j] += dp[i - 1][j]; // from top
                    if (j > 0) dp[i][j] += dp[i][j - 1]; // from left
                }
            }
        }

        return dp[rows - 1][cols - 1];
    }
}
