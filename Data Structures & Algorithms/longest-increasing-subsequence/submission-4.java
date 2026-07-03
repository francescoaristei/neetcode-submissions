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

For this specific problem:

The dfs(nums, i) function doesn't branch into n recursive calls at every level. 
It only recurses on elements after index i that are greater than nums[i]. 
Each subsequent element in the array is either:
Included in the subsequence (recurse on it), or
Skipped (not recursed on)


Let's trace through a concrete example
Take nums = [1, 2, 3, 4] (worst case — fully sorted).
What the code does starting from index 0:
dfs(nums, 0)  →  nums[0] = 1
├── dfs(nums, 1)  →  nums[1] = 2
│   ├── dfs(nums, 2)  →  nums[2] = 3
│   │   └── dfs(nums, 3)  →  nums[3] = 4  ✓ (subsequence: 1,2,3,4)
│   └── dfs(nums, 3)  →  nums[3] = 4      ✓ (subsequence: 1,2,4)
├── dfs(nums, 2)  →  nums[2] = 3
│   └── dfs(nums, 3)  →  nums[3] = 4      ✓ (subsequence: 1,3,4)
└── dfs(nums, 3)  →  nums[3] = 4          ✓ (subsequence: 1,4)
Starting from index 0, the code explores every increasing subsequence that starts with 1. That's:
{1}, {1,2}, {1,3}, {1,4}, {1,2,3}, {1,2,4}, {1,3,4}, {1,2,3,4}
That's 2³ = 8 subsequences (each of the 3 remaining elements is either included or not).
Now repeat for all starting indices:
2³ = 8
2² = 4
2¹ = 2
2⁰ = 1

Total = 8 + 4 + 2 + 1 = 15 ≈ 2⁴ = 2ⁿ

NOTE: the actual complexity is O(2ⁿ * n) since each recursive call
costs O(n) with the for loop.

The memoization solution I did instead costs  O(n²) since in this case
you have i = 1..n unique subproblems and each it cost O(n) with the for loop
There for O(n * n) = O(n²)

MENTAL MODEL FOR MEMOIZATION

Mental model for memoization complexity
Here's a simple formula that always works:
Time = (number of unique subproblems) × (work per subproblem, excluding recursive calls)
Apply it step by step:
Step 1: How many unique states can dfs(i) be called with?
The only parameter is i, which ranges from 0 to n-1 → n unique states.
Step 2: For one call to dfs(i), how much work does it do ignoring the recursive calls?
The for loop iterates from i+1 to n-1 and does O(1) per iteration (comparison, Math.max). Worst case: O(n).
Step 3: Multiply
n states × O(n) work per state = O(n²)

Key intuition
Without memo: you re-solve the same subproblem many times → exponential blowup.
With memo: each subproblem is solved exactly once, then cached. So you just count:
How many distinct subproblems exist?
How expensive is each one (excluding recursion)?
 
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
