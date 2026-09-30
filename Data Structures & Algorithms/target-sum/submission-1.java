class Solution {
    private record Pair(int i, int sum) {};
    private Map<Pair, Integer> memo = new HashMap<>();

    private int rec(int[] nums, int i, int sum, int target) {
        if (sum == target && i == nums.length) {
            return 1;
        }

        if (memo.containsKey(new Pair(i, sum))) {
            return memo.get(new Pair(i, sum));
        }

        if (i >= nums.length) {
            return 0;
        }

        memo.put(new Pair(i, sum), rec(nums, i + 1, sum + nums[i], target) + 
            rec(nums, i + 1, sum - nums[i], target));

        return memo.get(new Pair(i, sum));            
    }

    public int findTargetSumWays(int[] nums, int target) {
        return rec(nums, 0, 0, target);
    }
}
