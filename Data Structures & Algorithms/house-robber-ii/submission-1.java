class Solution {

    private int last(int i, int[] memo, int[] nums) {
        if (i <= 0) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        memo[i] = Math.max(nums[i] + last(i - 2, memo, nums), last(i - 1, memo, nums));
        return memo[i];
    }

    private int first(int i, int[] memo, int[] nums) {
        if (i >= nums.length - 1) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        memo[i] = Math.max(nums[i] + first(i + 2, memo, nums), first(i + 1, memo, nums));
        return memo[i];
    }
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] memoFirst = new int[nums.length];
        int[] memoLast = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memoFirst[i] = -1;
            memoLast[i] = -1;
        }

        return Math.max(first(0, memoFirst, nums), last(nums.length - 1, memoLast, nums));
    }
}
