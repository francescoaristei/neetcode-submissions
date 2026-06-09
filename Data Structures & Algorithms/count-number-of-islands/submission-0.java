class Solution {
    private void numIslandsRec(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1
            || grid[i][j] != '1' || visited[i][j]) {
            return;
        }
        
        visited[i][j] = true;
        numIslandsRec(grid, i - 1, j, visited);
        numIslandsRec(grid, i + 1, j, visited);
        numIslandsRec(grid, i, j - 1, visited);
        numIslandsRec(grid, i, j + 1, visited);
    }

    public int numIslands(char[][] grid) {
        // default to value false
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    numIslandsRec(grid, i, j, visited);
                    res += 1;
                }
            }
        }
        return res;
    }
}
