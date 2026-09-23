class Solution {
    private record Pair(int i, int j) {};
    private Map<Pair, Integer> memo = new HashMap<>();

    private int rec(String t1, String t2, int i, int j) {
        if (i == t1.length() || j == t2.length()) {
            return 0;
        }

        if (memo.containsKey(new Pair(i, j))) {
            return memo.get(new Pair(i, j));
        }

        if (t1.charAt(i) == t2.charAt(j)) {
            memo.put(new Pair(i, j), 1 + rec(t1, t2, i + 1, j + 1));
        } else {
            memo.put(new Pair(i, j), Math.max(rec(t1, t2, i + 1, j), rec(t1, t2, i, j + 1)));
        }

        //System.out.println("Pair: " + "(" + i + ", " + j + ")" + ": " + memo.get(new Pair(i, j)));
        return memo.get(new Pair(i, j));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        return rec(text1, text2, 0, 0);
    }
}
