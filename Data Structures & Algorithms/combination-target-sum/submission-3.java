class Solution {
    private List<List<Integer>> results = new ArrayList<>();
    private List<Integer> result = new ArrayList<>();

    private void rec(int[] nums, int target, int i, int sum) {
        if (sum == target) {
            List<Integer> temp = new ArrayList<>(result);
            results.add(temp);
            return;
        }

        if (sum > target || i >= nums.length) {
            return;
        }

        result.add(nums[i]);
        rec(nums, target, i, sum + nums[i]);

        result.remove(result.size() - 1);
        rec(nums, target, i + 1, sum);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        rec(nums, target, 0, 0);
        return results;
    }
}
