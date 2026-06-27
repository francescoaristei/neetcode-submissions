// memoization

class Solution {
    private int rec(int[] coins, int amount, int[][] memo, int i) {
        if (i >= coins.length || amount < 0) {
            return Integer.MAX_VALUE - 10;
        }
        if (amount == 0) {
            return 0;
        }
        if (memo[i][amount] != -1) {
            return memo[i][amount];
        }
        memo[i][amount] = Math.min(
            Math.min(
                1 + rec(coins, amount - coins[i], memo, i + 1),
                1 + rec(coins, amount - coins[i], memo, i)
            ),
            rec(coins, amount, memo, i + 1)
        );
        return memo[i][amount];
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[][] memo = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < amount + 1; j++) {
                memo[i][j] = -1;
            }
        }
        int res = rec(coins, amount, memo, 0);
        return res >= Integer.MAX_VALUE - 10 ? -1 : res;
    }
}
