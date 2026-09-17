class Solution {
    int[][] memo;

    private int rec(int[][] grid, int[][] memo, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return 1;
        }
        if (i == grid.length || j == grid[0].length) {
            return 0;
        }
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        memo[i][j] = rec(grid, memo, i + 1, j) + rec(grid, memo, i, j + 1);
        return memo[i][j];
    }
    
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        memo = new int[m][n];
        return rec(grid, memo, 0, 0);
    }
}
