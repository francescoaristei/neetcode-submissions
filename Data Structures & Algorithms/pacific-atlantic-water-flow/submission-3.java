/*
* For each cell in the Pacific and Atlantic borders
* you find all cells (including themselves) which are reachable
* and add them in a Set<Pair> for atlantic and one for pacific.
* Then iterate through all the cells and check if (i, j) is in both
* In this way you do not need to apply backtracking for each cell in
* the grid.
*/

class Solution {
    private record Pair(Integer i, Integer j){};
    private Set<Pair> atlantic = new HashSet<>();
    private Set<Pair> pacific = new HashSet<>();
    private Set<Pair> visited = new HashSet<>();

    private void pDfs(int[][] h, int i, int j, int val) {
        if (i < 0 || j < 0 || i >= h.length || j >= h[0].length 
            || h[i][j] < val || visited.contains(new Pair(i, j))) {
            return;
        }

        pacific.add(new Pair(i, j));
        visited.add(new Pair(i, j));

        pDfs(h, i - 1, j, h[i][j]);
        pDfs(h, i + 1, j, h[i][j]);
        pDfs(h, i, j - 1, h[i][j]);
        pDfs(h, i, j + 1, h[i][j]);

        //visited.remove(new Pair(i, j));
    }


    private void aDfs(int[][] h, int i, int j, int val) {
        if (i < 0 || j < 0 || i >= h.length || j >= h[0].length 
            || h[i][j] < val || visited.contains(new Pair(i, j))) {
            return;
        }
        
        atlantic.add(new Pair(i, j));
        visited.add(new Pair(i, j));

        aDfs(h, i - 1, j, h[i][j]);
        aDfs(h, i + 1, j, h[i][j]);
        aDfs(h, i, j - 1, h[i][j]);
        aDfs(h, i, j + 1, h[i][j]);

        //visited.remove(new Pair(i, j));
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;

        // pacific
        for (int i = 0; i < rows; i++) {
            pDfs(heights, i, 0, Integer.MIN_VALUE);
            visited = new HashSet<>();
        }

        for (int j = 0; j < cols; j++) {
            pDfs(heights, 0, j, Integer.MIN_VALUE);
            visited = new HashSet<>();
        }

        

        // atlantic
        for (int i = 0; i < rows; i++) {
            aDfs(heights, i, cols - 1, Integer.MIN_VALUE);
            visited = new HashSet<>();
        }

        for (int j = 0; j < cols; j++) {
            aDfs(heights, rows - 1, j, Integer.MIN_VALUE);
            visited = new HashSet<>();
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
