class Solution {
    private void bfs(int node, List<List<Integer>> nodes, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;

        while(!q.isEmpty()) {
            Integer n = q.poll();

            for (Integer ne: nodes.get(n)) {
                if (!visited[ne]) {
                    visited[ne] = true;
                    q.offer(ne);
                }
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        int res = 0;
        boolean[] visited = new boolean[n];
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
                bfs(i, adjList, visited);
                res++;
            }
        }
        return res;
    }
}
