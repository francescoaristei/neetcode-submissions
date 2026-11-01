class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = 0;

        int res = Integer.MAX_VALUE;
        int sum = 0;

        while (l <= r) {
            while (l <= r && sum >= target) {
                res = Math.min(res, r - l);
                sum -= nums[l];
                l++;
            }

            if (r >= len) {
                break;
            }
            
            sum += nums[r];
            r++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}