class Solution {
    private int[][] directions = {{-1, 0}, {+1, 0}, {0, -1}, {0, +1}};

    public int orangesRotting(int[][] grid) {

        int ROWS = grid.length;
        int COLS = grid[0].length;

        // rewrite to apply parallel BFS
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = -1;
                } else if (grid[i][j] == 1) {
                    grid[i][j] = Integer.MAX_VALUE;
                } else {
                    grid[i][j] = 0;
                }
            }
        }

        // fill queue
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        boolean[][] visit = new boolean[ROWS][COLS];

        // apply parallel BFS
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int r = p[0];
            int c = p[1];
            visit[r][c] = true;
            for (int[] dir: directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < ROWS && nc >= 0 
                    && nc < COLS && grid[nr][nc] > 0
                    && !visit[nr][nc]) {
                    q.offer(new int[]{nr, nc});
                    if (grid[nr][nc] > grid[r][c] + 1) {
                        grid[nr][nc] = grid[r][c] + 1;
                    }
                } 
            }
        }

        int max = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == Integer.MAX_VALUE) {
                    return -1;
                }
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
        }
        return max;
    }
}
