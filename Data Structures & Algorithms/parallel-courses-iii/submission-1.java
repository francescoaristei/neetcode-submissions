class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] maxTime = new int[time.length];
        int[] inDegree = new int[n + 1];
        int result = 0;

        for (int i = 0; i < time.length; i++) {
            result = Math.max(result, time[i]);
        }

        for (int i = 0; i < relations.length; i++) {
            graph.computeIfAbsent(relations[i][0], k -> new ArrayList<>()).add(relations[i][1]);
        }

        for (List<Integer> neighbors: graph.values()) {
            for (Integer ne: neighbors) {
                inDegree[ne]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()) {
            int node = q.poll();

            for (int nei: graph.getOrDefault(node, List.of())) {
                maxTime[nei - 1] = Math.max(maxTime[nei - 1], time[node - 1]);
                if (--inDegree[nei] == 0) {
                    time[nei - 1] += maxTime[nei - 1];
                    result = Math.max(result, time[nei - 1]);
                    q.offer(nei);
                }
            }
        }

        return result;

    }
}
