class UnionFind {
    private int[] parents;

    public UnionFind(int len) {
        parents = new int[len];
        for (int i = 0; i < len; i++) {
            parents[i] = i;
        }
    }

    public int find(int i) {
        if (i == parents[i]) {
            return i;
        }
        return find(parents[i]);
    }

    public void union(int i, int j) {
        int pi = find(i);
        int pj = find(j);

        if (pi == pj) {
            return;
        }
        parents[pj] = pi;
    }
}

class Solution {
    private record Pair(Integer i, Integer j){};
    private Set<Pair> visited = new HashSet<>();
    int res = 0;

    private void dfs(char[][] grid, int i, int j, UnionFind uf) {
        visited.add(new Pair(i, j));

        if (i - 1 >= 0 && grid[i - 1][j] == '1' && !visited.contains(new Pair(i - 1, j))) {
            uf.union(i * grid[0].length + j, (i - 1) * grid[0].length + j);
        }
        if (i + 1 < grid.length && grid[i + 1][j] == '1' && !visited.contains(new Pair(i + 1, j))) {
            uf.union(i * grid[0].length + j, (i + 1) * grid[0].length + j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1' && !visited.contains(new Pair(i, j - 1))) {
            uf.union(i * grid[0].length + j, i * grid[0].length + j - 1);
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1' && !visited.contains(new Pair(i, j + 1))) {
            uf.union(i * grid[0].length + j, i * grid[0].length + j + 1);
        }
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        UnionFind uf = new UnionFind(rows * cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited = new HashSet<>();
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, uf);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && uf.find(i * grid[0].length + j) == i * grid[0].length + j) {
                    res += 1;
                }
            }
        }
        return res;
    }
}
