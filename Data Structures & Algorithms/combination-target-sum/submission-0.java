class Solution {
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> result = new ArrayList<>();

    private void backtrack(int[] nums, int target, int idx, int sum) {
        if (idx < nums.length) {
            if (sum == target) {
                List<Integer> temp = new ArrayList<>(result);
                results.add(temp);
                return;
            }
            if (sum < target) {
                result.add(nums[idx]);
                backtrack(nums, target, idx, sum + nums[idx]);

                result.remove(result.size() - 1);
                backtrack(nums, target, idx + 1, sum);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return results;
    }
}