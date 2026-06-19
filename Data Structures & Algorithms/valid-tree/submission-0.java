// Valid Tree: in DSA a valid tree is a undirected graph which is:
//  - connected
//  - acyclic

// Solution:
// Build graph data structure
// Apply DFS or BFS algorithms and save nodes
// in the set nodes, if graph has cycles DFS or BFS
// returns false, if some nodes are not in the set 
// graph is not connected and return false
// otherwise return true
// O(N + V) with V = vertices and E = edges

class Graph {
    List<List<Integer>> nodes = new ArrayList<>();

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

    private boolean dfs(int node, List<List<Integer>> nodes, int parent, boolean[] visited) {
        allNodes.add(node);
        visited[node] = true;

        for (Integer ne: nodes.get(node)) {
            if (!visited[ne]) {
                if (dfs(ne, nodes, node, visited)) {
                    return true;
                }
            } else if (ne != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        // default to false
        boolean[] visited = new boolean[n];

        Graph graph = new Graph(n, edges);
        List<List<Integer>> nodes = graph.getList();
        boolean hasCycles = dfs(0, nodes, -1, visited);
        if (hasCycles) {
            return false;
        }

        // not connected
        for (int i = 0; i < n; i++) {
            if (!allNodes.contains(i)) {
                return false;
            }
        }

        return true;
    }
}
