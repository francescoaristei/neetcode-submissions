class Solution {
    private boolean dfs(int node, int parent, 
        boolean[] visited, List<List<Integer>> graph) {

        if (visited[node]) {
            return true;
        }

        visited[node] = true;

        for (int nei: graph.get(node)) {
            if (nei == parent) {
                continue;
            }
            if (dfs(nei, node, visited, graph)) {
                return true;
            }
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);

            boolean[] visited = new boolean[n + 1];

            if (dfs(u, -1, visited, graph)) {
                return new int[] {u, v};
            }
        }
        return new int[2];
    }
}
