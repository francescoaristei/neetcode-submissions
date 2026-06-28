class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();

    private int rec(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int res = Integer.MAX_VALUE;
        for (Integer coin: coins) {
            if (amount - coin >= 0) {
                int result = rec(coins, amount - coin);
                if (result != Integer.MAX_VALUE) {
                    res = Math.min(res, 1 + result);
                }
            }
        }
        memo.put(amount, res);
        return res;
    }

    public int coinChange(int[] coins, int amount) {
        int res = rec(coins, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
