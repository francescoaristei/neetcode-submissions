// tabulation

class Solution {
    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dpF = new int[nums.length];
        int[] dpL = new int[nums.length];

        dpF[0] = nums[0];
        dpF[1] = Math.max(nums[1], dpF[0]);

        for (int i = 2; i < nums.length - 1; i++) {
            dpF[i] = Math.max(dpF[i - 1], nums[i] + dpF[i - 2]);
        
        }

        dpL[nums.length - 1] = nums[nums.length - 1];
        dpL[nums.length - 2] = Math.max(nums[nums.length - 2], dpL[nums.length - 1]);

        for (int i = nums.length - 3; i > 0; i--) {
            dpL[i] = Math.max(nums[i] + dpL[i + 2], dpL[i + 1]);
        }

        return Math.max(dpF[nums.length - 2], dpL[1]);

    }
}
