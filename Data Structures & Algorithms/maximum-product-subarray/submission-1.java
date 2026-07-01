// memoization

class Solution {
    private record Pair(Integer i, Integer j){};
    private Map<Pair, Integer> memo = new HashMap<>();

    private int subProd(int[] nums, int i, int j) {
        int res = 1;
        for (int c = i; c <= j; c++) {
            res *= nums[c];
        }
        return res;
    }

    private int rec(int[] nums, int i, int j) {
        if (i == j) {
            return nums[i];
        }

        if (memo.containsKey(new Pair(i, j))) {
            return memo.get(new Pair(i, j));
        }

        memo.put(
            new Pair(i, j),
            Math.max(
                subProd(nums, i, j),
                Math.max(
                    rec(nums, i + 1, j), 
                    rec(nums, i, j - 1))
        ));
        return memo.get(new Pair(i, j));
    }
    public int maxProduct(int[] nums) {
        return rec(nums, 0, nums.length - 1);
    }
}

