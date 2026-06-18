
class Solution {
    private record Pair(Integer i, Integer j){};
    private Set<Pair> atlantic = new HashSet<>();
    private Set<Pair> pacific = new HashSet<>();
    private Set<Pair> aVis = new HashSet<>();
    private Set<Pair> pVis = new HashSet<>();

    private void dfs(int[][] h, int i, int j, int val, Set<Pair> vOc, Set<Pair> oc) {
        if (i < 0 || j < 0 || i >= h.length || j >= h[0].length 
            || h[i][j] < val || vOc.contains(new Pair(i, j))) {
            return;
        }

        oc.add(new Pair(i, j));
        vOc.add(new Pair(i, j));

        dfs(h, i - 1, j, h[i][j], vOc, oc);
        dfs(h, i + 1, j, h[i][j], vOc, oc);
        dfs(h, i, j - 1, h[i][j], vOc, oc);
        dfs(h, i, j + 1, h[i][j], vOc, oc);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;

        // pacific
        for (int i = 0; i < rows; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pVis, pacific);
            //visited = new HashSet<>();
        }

        for (int j = 0; j < cols; j++) {
            dfs(heights, 0, j, Integer.MIN_VALUE, pVis, pacific);
            //visited = new HashSet<>();
        }

        

        // atlantic
        for (int i = 0; i < rows; i++) {
            dfs(heights, i, cols - 1, Integer.MIN_VALUE, aVis, atlantic);
            //visited = new HashSet<>();
        }

        for (int j = 0; j < cols; j++) {
            dfs(heights, rows - 1, j, Integer.MIN_VALUE, aVis, atlantic);
            //visited = new HashSet<>();
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (atlantic.contains(new Pair(i, j)) && pacific.contains(new Pair(i, j))) {
                    res.add(new ArrayList<>(List.of(i, j)));
                }
            }
        }
        return res;
    }
}
