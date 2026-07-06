class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            int temp = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i] && temp < dp[j]) {
                    temp = dp[j];
                }
            }
            dp[i] = 1 + temp;
        }

        int max = 0;
        for (int j = 0; j < dp.length; j++) {
            if (max < dp[j]) {
                max = dp[j];
            }
        }
        return max;
    }
}
