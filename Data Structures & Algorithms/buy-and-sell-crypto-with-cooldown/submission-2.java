class Solution {
    record Pair(int i, boolean b){};
    Map<Pair, Integer> memo = new HashMap<>();

    private int rec(int[] prices, int i, boolean buying) {
        if (i >= prices.length) {
            return 0;
        }

        if (memo.containsKey(new Pair(i, buying))) {
            return memo.get(new Pair(i, buying));
        }

        if (buying) {
            memo.put(new Pair(i, buying), Math.max(rec(prices, i + 1, false) - prices[i], rec(prices, i + 1, buying)));
        } else {
            memo.put(new Pair(i, buying), Math.max(rec(prices, i + 2, true) + prices[i], rec(prices, i + 1, buying)));
        }
        return memo.get(new Pair(i, buying));
    }


    public int maxProfit(int[] prices) {
        return rec(prices, 0, true);
    }
}
