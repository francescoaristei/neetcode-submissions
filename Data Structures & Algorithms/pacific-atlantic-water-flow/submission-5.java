class Solution {
    private record Pair(Integer i, Integer j){};
    private Set<Pair> visited = new HashSet<>();
    private Set<Pair> atlantic = new HashSet<>();
    private Set<Pair> pacific = new HashSet<>();

    private void bfs(int[][] h, int i, int j, Set<Pair> ocean) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            ocean.add(p);
            visited.add(p);

            if (p.i() - 1 >= 0 && !visited.contains(new Pair(p.i() - 1, p.j()))
                && h[p.i() - 1][p.j()] >= h[p.i()][p.j()]) {
                q.offer(new Pair(p.i() - 1, p.j()));
            }
            if (p.i() + 1 <  h.length && !visited.contains(new Pair(p.i() + 1, p.j()))
                && h[p.i() + 1][p.j()] >= h[p.i()][p.j()]) {
                q.offer(new Pair(p.i() + 1, p.j()));
            }
            if (p.j() - 1 >= 0 && !visited.contains(new Pair(p.i(), p.j() - 1))
                && h[p.i()][p.j() - 1] >= h[p.i()][p.j()]) {
                q.offer(new Pair(p.i(), p.j() - 1));
            }
            if (p.j() + 1 < h[0].length && !visited.contains(new Pair(p.i(), p.j() + 1))
                && h[p.i()][p.j() + 1] >= h[p.i()][p.j()]) {
                q.offer(new Pair(p.i(), p.j() + 1));
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        List<List<Integer>> res = new ArrayList<>();

        // pacific
        for (int i = 0; i < rows; i++) {
            bfs(heights, i, 0, pacific);
            visited = new HashSet<>();
        }

        for (int j = 0; j < cols; j++) {
            bfs(heights, 0, j, pacific);
            visited = new HashSet<>();
        }

        // atlantic
        for (int i = 0; i < rows; i++) {
            bfs(heights, i, cols - 1, atlantic);
            visited = new HashSet<>();
        }

        for (int j = 0; j < cols; j++) {
            bfs(heights, rows - 1, j, atlantic);
            visited = new HashSet<>();
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (atlantic.contains(new Pair(i, j)) 
                    && pacific.contains(new Pair(i, j))) {
                    res.add(new ArrayList<>(List.of(i, j)));
                }
            }
        }
        return res;
    }
}
