// memoization
/*
MENTAL MODEL FOR TIME COMPLEXITY

Your mental model isn't wrong — it just needs a nuance. Let me clarify when it works and when it doesn't.
Your mental model: O(choices^depth × cost_per_call)
This works for fixed branching problems where every node in the recursion tree has the same number of children.
Example where it works: Permutations
// At every level, you try all n elements
void permute(int level) {
    for (int i = 0; i < n; i++) {   // always n choices
        if (!used[i]) {
            permute(level + 1);
        }
    }
}
Choices per level: n (fixed)
Depth: n
Result: nⁿ (or more precisely n! since used prunes, but the upper bound formula applies)
Why it breaks here: the branching is not fixed
In the LIS code:
Level 0: up to (n-1) branches
Level 1: up to (n-2) branches
Level 2: up to (n-3) branches
...
Level k: up to (n-1-k) branches
You can't say "choices = n" because the number of choices shrinks at every level. There's no single constant to plug into choices^depth.
 
Better mental model for this type of problem
When each element is visited at most once per path and the decision is "include it or don't", think of it as:
Each element has 2 options → 2ⁿ total paths
This applies to:
Subsets / subsequences
Knapsack (brute force)
Any "take or skip" recursion
 
Summary: Two mental models
Pattern
Formula
Example
Fixed branching (same choices at every level)
choices^depth
Permutations, n-queens, sudoku
Shrinking / binary "take-or-skip"
2^n
Subsets, LIS, knapsack
Your model is correct for the first category. 
For the second, just ask: 
"Is each element independently included or excluded?" If yes → 2ⁿ.

*/

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
