class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int area = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                int temp = 0;
                if (grid[x][y] == 1) {
                    q.offer(new int[]{x, y});
                    grid[x][y] = 0;
                    while (!q.isEmpty()) {
                        int[] pair = q.poll();
                        int i = pair[0];
                        int j = pair[1];
                        temp++;
                        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                            q.offer(new int[]{i - 1, j});
                            grid[i - 1][j] = 0;
                        }
                        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                            q.offer(new int[]{i + 1, j});
                            grid[i + 1][j] = 0;
                        }
                        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                            q.offer(new int[]{i, j - 1});
                            grid[i][j - 1] = 0;
                        }
                        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                            q.offer(new int[]{i, j + 1});
                            grid[i][j + 1] = 0;
                        }
                    }
                }
                area = Math.max(area, temp);
            }
        }
        return area;
    }
}
