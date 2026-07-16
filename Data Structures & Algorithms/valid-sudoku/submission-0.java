class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check rows
        for (int i = 0; i < board.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (set.contains(board[i][j] - '0')) {
                    return false;
                }
                if (board[i][j] != '.') {
                    set.add(board[i][j] - '0');
                }
            }
        }

        // check columns
        for (int j = 0; j < board[0].length; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                if (set.contains(board[i][j] - '0')) {
                    return false;
                }
                if (board[i][j] != '.') {
                    set.add(board[i][j] - '0');
                }
                
            }
        }

        int[] b = {0, 3, 6};

        // check 3 x 3 boxes
        for (int x = 0; x < b.length; x++) {
            for (int y = 0; y < b.length; y++) {
                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (set.contains(board[i + b[x]][j + b[y]] - '0')) {
                            return false;
                        }
                        if (board[i + b[x]][j + b[y]] != '.') {
                            set.add(board[i + b[x]][j + b[y]] - '0');
                        }
                    }
                }
            }
        }

        return true;
    }
}
