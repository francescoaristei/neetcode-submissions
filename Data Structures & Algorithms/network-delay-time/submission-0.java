class Solution {
    private Map<Integer, List<int[]>> buildGraph(int[][] times) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] edge: times) {
            List<int[]> list = graph.getOrDefault(edge[0], new ArrayList<>());
            list.add(new int[] {edge[1], edge[2]});
            graph.put(edge[0], list);
        }
        return graph;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {0, k});

        Map<Integer, List<int[]>> graph = buildGraph(times);

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (graph.containsKey(curr[1])) {
                for (int[] edge: graph.get(curr[1])) {
                    int newDist = dist[curr[1]] + edge[1];
                    if (newDist < dist[edge[0]]) {
                        dist[edge[0]] = newDist;
                        pq.offer(new int[] {newDist, edge[0]});
                    }
                }
            }
        }
        int max = dist[1];
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            if (dist[i] > max) {
                max = dist[i];
            }
        }
        return max;
    }
}
