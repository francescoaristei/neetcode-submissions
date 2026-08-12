// memoization

class Solution {

    private boolean rec(int[] nums, int i, int target, int sum, boolean[] memo) {
        if (target == sum) {
            return true;
        }

        if (i >= nums.length) {
            return false;
        }

        if (memo[i]) {
            return true;
        }

        memo[i] = rec(nums, i + 1, target, sum + nums[i], memo) || 
            rec(nums, i + 1, target, sum, memo);

        return memo[i];
    }

    public boolean canPartition(int[] nums) {
        boolean[] memo = new boolean[nums.length];

        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            target += nums[i];
        }
        if (target % 2 != 0) {
            return false;
        }

        target /= 2;
        return rec(nums, 0, target, 0, memo);
    }
}
