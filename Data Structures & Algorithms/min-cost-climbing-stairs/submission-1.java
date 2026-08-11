class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();

    private int rec(int[] cost, int i) {
        if (i >= cost.length) {
            return 0;
        }

        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        memo.put(i, Math.min(cost[i] + rec(cost, i + 1), 
            cost[i] + rec(cost, i + 2)));

        return memo.get(i);
    }

    public int minCostClimbingStairs(int[] cost) {
        return Math.min(rec(cost, 0), rec(cost, 1));
    }
}
