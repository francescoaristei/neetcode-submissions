class Solution {
    private record Pair(int i, int amount) {};
    private Map<Pair, Integer> memo = new HashMap<>();

    private int rec(int amount, int[] coins, int i) {
        if (amount == 0) {
            return 1;
        }

        if (memo.containsKey(new Pair(i, amount))) {
            return memo.get(new Pair(i, amount));
        }

        if (i >= coins.length || amount < 0) {
            return 0;
        }

        memo.put(new Pair(i, amount), rec(amount - coins[i], coins, i) +
            rec(amount, coins, i + 1));

        return memo.get(new Pair(i, amount));
    }

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        return rec(amount, coins, 0);
    }
}
