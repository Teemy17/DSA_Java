package solutions.pack7_Recursion;

// time complexity: O(2^(m+n)) where m and n is the dimension of the grid
public class GridPaths {
    public static int numberOfPaths(int[][] grid) {
       if (grid == null || grid.length == 0 || grid[0].length == 0) {
           return 0;
       }
         return countsPath(grid, 0, 0);
    }

    public static int countsPath(int [][] grid, int row, int col) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return 1;
        }
        if (row >= grid.length || col >= grid[0].length) {
            return 0;
        }
        if (grid[row][col] == 1) {
            return 0;
        }
        return countsPath(grid, row + 1, col) + countsPath(grid, row, col + 1);
    }
}
