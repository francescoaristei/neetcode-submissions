class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    private void backtrack(int[] nums, boolean[] arr, int i) {
        if (list.size() == nums.length) {
            List<Integer> temp = new ArrayList<>(list);
            res.add(temp);
            return;
        }

        for (int j = 0; j < arr.length; j++) {
            if (!arr[j]) {
                list.add(nums[j]);
                arr[j] = true;
                backtrack(nums, arr, j);

                // backtrack
                list.remove(list.size() - 1);
                arr[j] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] arr = new boolean[nums.length];
        backtrack(nums, arr, 0);
        return res;
    }
}
