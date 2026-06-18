class Graph {
    List<List<Integer>> graph = new ArrayList<>();

    public Graph(int size, int[][] nodes) {
        for (int i = 0; i < size; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < nodes.length; i++) {
            graph.get(nodes[i][1]).add(nodes[i][0]);
        }
    }

    public int getSize() {
        return graph.size();
    }

    public List<List<Integer>> getGraph() {
        return graph;
    }
}

class Solution {

    private boolean dfs(Integer node, List<List<Integer>> graph, boolean[] visited, boolean[] rec) {
        if (rec[node]) {
            return true;
        }

        if (visited[node]) {
            return false;
        }

        rec[node] = true;
        visited[node] = true;

        for (Integer ne: graph.get(node)) {
            if (dfs(ne, graph, visited, rec)) {
                return true;
            }
        }
        rec[node] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses, prerequisites);
        List<List<Integer>> nodes = graph.getGraph();

        boolean[] rec = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && dfs(i, nodes, visited, rec)) {
                return false;
            }
        }
        return true;
    }
}
