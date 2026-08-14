class Solution {
    private int[][] directions = {{+1, 0}, {-1, 0}, {0, +1}, {0, -1}};

    private void dfs(char[][] board, boolean[][] bad, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length 
            || board[i][j] == 'X' || bad[i][j]) {
            return;
        }

        bad[i][j] = true;

        for (int[] dir: directions) {
            dfs(board, bad, i + dir[0], j + dir[1]);
        }
    }


    public void solve(char[][] board) {
        boolean[][] bad = new boolean[board.length][board[0].length];
        int[] rBoarders = {0, board.length - 1};
        int[] cBoarders = {0, board[0].length - 1};

        for (int i: rBoarders) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    dfs(board, bad, i, j);
                }
            }
        }

        for (int j: cBoarders) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == 'O') {
                    dfs(board, bad, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!bad[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
