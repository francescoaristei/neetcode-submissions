class Solution {
    public int jump(int[] nums) {
        int l = 0; 
        int r = 0;
        int count = 0;

        while (r < nums.length - 1) {
            int max = 0;
            for (int i = l; i <= r; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            l = r + 1;
            r += max;
            count++;
        }
        return count;
    }
}
