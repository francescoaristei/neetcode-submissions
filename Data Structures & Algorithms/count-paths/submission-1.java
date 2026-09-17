class Solution {
    private record Pair(int i, int j) {};
    private int nPaths = 0;
    private Map<Pair, Integer> memo = new HashMap<>();

    private int rec(int[][] grid, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return 1;
        }
        if (memo.containsKey(new Pair(i, j))) {
            return memo.get(new Pair(i, j));
        }
        if (i == grid.length || j == grid[0].length) {
            return 0;
        }
        memo.put(new Pair(i, j), rec(grid, i + 1, j) + rec(grid, i, j + 1));
        return memo.get(new Pair(i, j));
    }

    public int uniquePaths(int m, int n) {
        int[][] grid = new int[n][m];
        return rec(grid, 0, 0);
    }
}
