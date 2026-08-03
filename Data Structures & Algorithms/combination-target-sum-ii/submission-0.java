class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    private void rec(int[] candidates, int target, int i, int sum) {
        if (sum == target) {
            List<Integer> temp = new ArrayList<>(list);
            res.add(temp);
            return;
        }

        if (i >= candidates.length || sum > target) {
            return;
        }

        list.add(candidates[i]);
        rec(candidates, target, i + 1, sum + candidates[i]);

        // backtrack
        list.remove(list.size() - 1);

        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) { 
            i++;
        }

        rec(candidates, target, i + 1, sum);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        rec(candidates, target, 0, 0);
        return res;
    }
}
