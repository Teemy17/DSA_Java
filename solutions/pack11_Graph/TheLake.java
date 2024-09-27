package solutions.pack11_Graph;

public class TheLake {

    // Directions for moving up, down, left, and right
    private static final int[] rowDirections = {-1, 1, 0, 0};
    private static final int[] colDirections = {0, 0, -1, 1};

    public int findTotalMaxDepth(int[][] input) {
        int totalMaxDepth = 0;
        int rows = input.length;
        int cols = input[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // Iterate through each cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (input[i][j] != 0 && !visited[i][j]) {
                    // For each unvisited water cell, find the total depth of the lake
                    int lakeDepth = dfs(input, visited, i, j, rows, cols);
                    // Update the maximum depth found
                    totalMaxDepth = Math.max(totalMaxDepth, lakeDepth);
                }
            }
        }
        return totalMaxDepth;
    }

    // Depth-first search
    private int dfs(int[][] input, boolean[][] visited, int row, int col, int rows, int cols) {
        // Base case: return 0 if out of bounds or if it's a land cell or already visited
        if (row < 0 || row >= rows || col < 0 || col >= cols || input[row][col] == 0 || visited[row][col]) {
            return 0;
        }

        // Mark this cell as visited
        visited[row][col] = true;

        // Initialize the depth sum for this cell
        int depth = input[row][col];

        // Explore all 4 directions (up, down, left, right)
        for (int d = 0; d < 4; d++) {
            int newRow = row + rowDirections[d];
            int newCol = col + colDirections[d];
            depth += dfs(input, visited, newRow, newCol, rows, cols);
        }

        return depth;
    }
}