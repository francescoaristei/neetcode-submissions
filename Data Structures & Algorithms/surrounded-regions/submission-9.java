
class UF {
    private int[] parents;
    private int[] sizes;

    public UF(int n) {
        parents = new int[n];
        sizes = new int[n];

        for (int i = 0; i < n; i++) {
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
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int n = rows * cols;
    
        // n + 1 for dummy node
        UF uf = new UF(n + 1);

        int[] rboard = {0, rows - 1};
        int[] cboard = {0, cols - 1};

        for (int i: rboard) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    // trick board -> union find
                    uf.union(cols * i + j, n);
                }
            }
        }

        for (int j: cboard) {
            for (int i = 0; i < rows; i++) {
                if (board[i][j] == 'O') {
                    // trick board -> union find
                    uf.union(cols * i + j, n);
                }
            }
        }

        int[][] dirs = {{+1, 0}, {-1, 0}, {0, +1}, {0, -1}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    for (int[] dir: dirs) {
                        int r = dir[0];
                        int c = dir[1];
                        int nr = i + r;
                        int nc = j + c;
                        if (nr >= 0 && nr < rows 
                            && nc >= 0 && nc < cols 
                            && board[nr][nc] == 'O') {
                            uf.union(i * cols + j, nr * cols + nc);
                        }
                    }
                }
            }
        }

        // flip to 'X'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O' && uf.find(i * cols + j) != uf.find(n)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
