class Solution {
    private void dfs(int node, List<List<Integer>> nodes, boolean[] visited) {
        visited[node] = true;

        for (Integer ne: nodes.get(node)) {
            if (!visited[ne]) {
                dfs(ne, nodes, visited);
            }
        }
    }


    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int res = 0;

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adjList, visited);
                res++;
            }
        }
        return res;
    }
}
