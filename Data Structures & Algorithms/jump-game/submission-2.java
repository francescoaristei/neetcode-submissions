class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        int curr = nums.length - 2;

        while (curr >= 0) {
            if (curr + nums[curr] >= goal) {
                goal = curr;
            }
            curr--;
        }
        return goal == 0;
    }
}
