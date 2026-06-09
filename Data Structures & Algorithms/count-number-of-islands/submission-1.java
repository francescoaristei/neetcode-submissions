class Solution {

    private void bfs(char[][] grid, int i, int j, boolean[][] v) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j});

        v[i][j] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            v[r][c] = true;

            if (r - 1 >= 0 && grid[r - 1][c] == '1' && !v[r - 1][c]) {
                q.offer(new int[] {r - 1, c});
            }
            if (r + 1 < grid.length && grid[r + 1][c] == '1' && !v[r + 1][c]) {
                q.offer(new int[] {r + 1, c});
            }
            if (c - 1 >= 0 && grid[r][c - 1] == '1' && !v[r][c - 1]) {
                q.offer(new int[] {r, c - 1});
            }
            if (c + 1 < grid[0].length && grid[r][c + 1] == '1' && !v[r][c + 1]) {
                q.offer(new int[] {r, c + 1});
            }
        }
    }

    public int numIslands(char[][] grid) {
        boolean[][] v = new boolean[grid.length][grid[0].length];
        int res = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !v[i][j]) {
                    bfs(grid, i, j, v);
                    res += 1;
                }
            }
        }
        return res;
    }
}
