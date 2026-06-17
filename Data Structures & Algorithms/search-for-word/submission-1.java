class Solution {
    private record Pair<A, B>(A i, B j) {}
    private Set<Pair<Integer, Integer>> set = new HashSet<>();

    private boolean rec(char[][] board, String word, int i, int j, int c) {
        if (c == word.length()) {
            return true;
        }

        if ((i < 0 || i >= board.length) || 
            (j < 0 || j >= board[0].length) ||
            set.contains(new Pair<>(i, j)) ||
            board[i][j] != word.charAt(c)) {
                return false;
            }
        
        c += 1;
        set.add(new Pair<>(i, j));
        
        boolean res = rec(board, word, i + 1, j, c) ||
            rec(board, word, i - 1, j, c) ||
            rec(board, word, i, j - 1, c) ||
            rec(board, word, i, j + 1, c);
        
        set.remove(new Pair<>(i, j));
        return res;
        
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (rec(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
