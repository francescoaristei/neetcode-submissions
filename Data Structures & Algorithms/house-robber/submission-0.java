class Solution {
    private int dfs(int i, int[] nums, int[] memo) {
        if (i >= nums.length) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        memo[i] = Math.max(nums[i] + dfs(i + 2, nums, memo), dfs(i + 1, nums, memo));
        return memo[i];
    }

    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = -1;
        }
        return dfs(0, nums, memo);
    }
}
