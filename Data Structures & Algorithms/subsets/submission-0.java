class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    private void rec(int[] nums, int i) {
        if (i >= nums.length) {
            List<Integer> temp = new ArrayList<>(list);
            res.add(temp);
            return;
        }

        list.add(nums[i]);
        rec(nums, i + 1);

        // backtrack
        list.remove(list.size() - 1);

        rec(nums, i + 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        rec(nums, 0);
        return res;
    }
}
