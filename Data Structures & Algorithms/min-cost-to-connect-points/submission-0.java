class UnionFind {
    private int[] parents;

    public UnionFind(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public int find(int i) {
        if (i == parents[i]) {
            return i;
        }
        return find(parents[i]);
    }

    public boolean union(int i, int j) {
        int pi = find(i);
        int pj = find(j);

        if (pi == pj) {
            return false;
        }

        parents[pj] = pi;
        return true;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i; j < points.length; j++) {
                int xi = points[i][0];
                int yi = points[i][1];
                int xj = points[j][0];
                int yj = points[j][1];
                int dist = Math.abs(xi - xj) + Math.abs(yi - yj);
                edges.add(new int[] {i, j, dist});
            }
        }
        edges.sort(Comparator.comparingInt(array -> array[2]));
        UnionFind uf = new UnionFind(points.length);
        int mstWeight = 0;
        int edgesUsed = 0;

        for (int[] e: edges) {
            if (uf.union(e[0], e[1])) {
                mstWeight += e[2];
                edgesUsed++;
                if (edgesUsed == points.length - 1) {
                    break;
                }
            }
        }
        return mstWeight;
    }
}
