class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    private void rec(int[] nums, int i) {
        if (i >= nums.length) {
            List<Integer> temp = new ArrayList<>(list);
            result.add(temp);
            return;
        }

        list.add(nums[i]);
        rec(nums, i + 1);

        // backtrack
        list.remove(list.size() - 1);

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        rec(nums, i + 1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        rec(nums, 0);
        return result;
    }
}
