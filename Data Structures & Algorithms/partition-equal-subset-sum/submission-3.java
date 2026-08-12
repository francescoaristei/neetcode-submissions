class Solution {
    private boolean rec(int[] nums, int i, int target, int sum) {
        if (target == sum) {
            return true;
        }

        if (i >= nums.length) {
            return false;
        }

        if (rec(nums, i + 1, target, sum + nums[i]) || rec(nums, i + 1, target, sum)) {
            return true;
        }

        return false;
    }

    public boolean canPartition(int[] nums) {
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            target += nums[i];
        }
        if (target % 2 != 0) {
            return false;
        }

        target /= 2;
        return rec(nums, 0, target, 0);
    }
}
