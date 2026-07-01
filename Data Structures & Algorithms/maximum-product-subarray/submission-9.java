class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMin = 1;
        int curMax = 1;

        for (int i = 0; i < nums.length; i++) {
            int tmp = curMax * nums[i];
            curMax = Math.max(Math.max(nums[i] * curMax, nums[i] * curMin), nums[i]);
            curMin = Math.min(Math.min(tmp, nums[i] * curMin), nums[i]);
            res = Math.max(res, curMax);
        }
        return res;
    }
}
