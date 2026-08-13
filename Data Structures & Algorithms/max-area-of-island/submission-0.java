class Solution {
    private record Pair(Integer i, Integer j){};
    private Set<Pair> visited = new HashSet<>();

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length 
            || j < 0 || j >= grid[0].length 
            || visited.contains(new Pair(i, j)) || grid[i][j] == 0) {
            return 0;
        }
        visited.add(new Pair(i, j));

        return 1 + dfs(grid, i - 1, j) 
                 + dfs(grid, i + 1, j)
                 + dfs(grid, i, j + 1)
                 + dfs(grid, i, j - 1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        List<Integer> areas = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited.contains(new Pair(i, j))) {
                    areas.add(dfs(grid, i, j));
                }
            }
        }
        for (int i = 0; i < areas.size(); i++) {
            if (areas.get(i) > result) {
                result = areas.get(i);
            }
        }
        return result;
    }
}
