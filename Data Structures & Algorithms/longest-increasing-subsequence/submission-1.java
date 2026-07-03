// memoization
// 

class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();

    private int dfs(int[] nums, int i) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        int max = 1;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                max = Math.max(max, 1 + dfs(nums, j));
                memo.put(i, max);
            }
        }
        return max;
    }
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dfs(nums, i));
        }
        return res;
    }
}
