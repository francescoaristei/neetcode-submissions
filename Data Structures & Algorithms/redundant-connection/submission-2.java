class UF {
    private int[] parents;
    private int[] sizes;

    public UF(int n) {
        parents = new int[n + 1];
        sizes = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
            sizes[i] = 1;
        }
    }

    public int find(int i) {
        if (parents[i] != i) {
            parents[i] = find(parents[i]);
        }
        return parents[i];
    }

    public boolean union(int i, int j) {
        int pi = find(i);
        int pj = find(j);

        if (pi == pj) {
            return false;
        }

        if (sizes[pi] >= sizes[pj]) {
            sizes[pi] += sizes[pj];
            parents[pj] = pi;
        } else {
            sizes[pj] += sizes[pi];
            parents[pi] = pj;
        }
        return true;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF(edges.length);
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            if (!uf.union(u, v)) {
                return edge;
            }
        }
        return new int[2];
    }
}
