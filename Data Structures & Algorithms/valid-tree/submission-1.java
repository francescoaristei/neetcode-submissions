class Graph {
    private List<List<Integer>> nodes = new ArrayList<>();

    public Graph(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            nodes.get(edges[i][0]).add(edges[i][1]);
            nodes.get(edges[i][1]).add(edges[i][0]);
        }
    }

    public List<List<Integer>> getList() {
        return nodes;
    }
}


class Solution {
    private Set<Integer> allNodes = new HashSet<>();

    private boolean bfs(int node, List<List<Integer>> nodes, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        Map<Integer, Integer> parentMap = new HashMap<>();
        
        while (!q.isEmpty()) {
            Integer n = q.poll();
            allNodes.add(n);

            for (Integer ne: nodes.get(n)) {
                if (!visited[ne]) {
                    visited[ne] = true;
                    q.offer(ne);
                    parentMap.put(ne, n);
                } else if (!(parentMap.get(n) == ne)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        Graph graph = new Graph(n, edges);
        List<List<Integer>> nodes = graph.getList();
        if (bfs(0, nodes, visited)) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (!allNodes.contains(i)) {
                return false;
            }
        }
        return true;
    }
}
