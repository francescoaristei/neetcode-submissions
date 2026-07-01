class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = Integer.MIN_VALUE;
        int lTr = 1;
        int rTl = 1;

        for (int i = 0; i < nums.length; i++) {
            if (lTr == 0) {
                lTr = 1;
            }
            if (rTl == 0) {
                rTl = 1;
            }

            lTr *= nums[i];

            int j = nums.length - i - 1;
            rTl *= nums[j];

            maxProd = Math.max(lTr, Math.max(maxProd, rTl));
        }

        return maxProd;
    }
}
