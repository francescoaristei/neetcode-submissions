class Solution {
    private int memoization(int n, int[] memo) {
        if (n <= 1) {
            return 1;
        }
        if (memo[n] != -1) {
            return memo[n];
        }

        memo[n] = memoization(n - 1, memo) + memoization(n - 2, memo);
        return memo[n];
    }

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        memo[n] = memoization(n, memo);
        return memo[n];
    }
}
