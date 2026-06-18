class Graph {
    private List<List<Integer>> graph = new ArrayList<>();

    public Graph(int n, int[][] nodes) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[0].length; j++) {
                graph.get(nodes[i][1]).add(nodes[i][0]);
            }
        }
    }

    public boolean hasCycle() {
        int visited = 0;

        int[] inc = new int[graph.size()];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.size(); i++) {
            for (Integer v: graph.get(i)) {
                inc[v]++;
            }
        }

        for (int i = 0; i < inc.length; i++) {
            if (inc[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            Integer n = q.poll();
            visited++;

            for (Integer ne: graph.get(n)) {
                inc[ne]--;
                if (inc[ne] == 0) {
                    q.offer(ne);
                }
            }
        }
        return graph.size() == visited;
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses, prerequisites);
        return graph.hasCycle();
    }
}
