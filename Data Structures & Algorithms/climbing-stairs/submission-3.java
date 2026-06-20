class Solution {
    private int dp(int c, int n, int[] memo) {
        if (c > n) {
            return 0;
        }
        if (c == n) {
            return 1;
        }
        if (memo[c] != - 1) {
            return memo[c];
        }
        memo[c] = dp(c + 1, n, memo) + dp(c + 2, n, memo);
        return memo[c];
    }

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i < n; i++) {
            memo[i] = -1;
        }
        memo[n] = dp(0, n, memo);
        return memo[n];
    }
}
