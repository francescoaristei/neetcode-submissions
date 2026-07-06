public class Solution {
    record Pair(Integer i, Integer j) {};
    Map<Pair, Integer> memo = new HashMap<>();

    public int lengthOfLIS(int[] nums) {
        return dfs(nums, 0, -1);
    }

    private int dfs(int[] nums, int i, int j) {
        if (i == nums.length) {
            return 0;
        }

        if (memo.containsKey(new Pair(i, j))) {
            return memo.get(new Pair(i, j));
        }

        int LIS = dfs(nums, i + 1, j); // not include

        if (j == -1 || nums[j] < nums[i]) {
            LIS = Math.max(LIS, 1 + dfs(nums, i + 1, i)); // include
        }

        memo.put(new Pair(i, j), LIS);
        return LIS;
    }
}