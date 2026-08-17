class UF {
    private int[] parents;
    private int[] sizes;

    public UF(int n) {
        parents = new int[n + 1];
        sizes = new int[n + 1];
        for (int i = 0; i < parents.length; i++) {
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
        int n = edges.length;
        UF uf = new UF(n);
        int edgesUsed = 0;
        Set<int[]> usedEdges = new HashSet<>();

        for (int[] edge: edges) {
            if (uf.union(edge[0], edge[1])) {
                usedEdges.add(edge);
                if (++edgesUsed == n - 1) {
                    break;
                }
            }
        }
        int[] res = new int[2];
        for (int[] edge: edges) {
            if (!usedEdges.contains(edge)) {
                res = edge;
            }
        }
        return res;
    }
}
