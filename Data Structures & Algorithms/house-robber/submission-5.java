// nums = [1, 10, 1, 1, 10, 1]
// The "skip" branch (dfs(i+1)) is what allows the algorithm 
// to skip more than one house between robberies — 
// it doesn't force you to take every other house. 
// At each position, you independently decide "rob this one and 
// jump 2" or "skip this one and reconsider the very next one," 
// which lets it explore all valid non-adjacent combinations.

// The time complexity of the trivial solution is O(2 to n)
// because at each step you can me two choices:
// - rob and go to i + 2
// - don't rob and go to i + 1
// this creates a binary tree
// If you always branch to i + 1 in the end
// the depth of the tree is n
// if you always branch in i + 2 it will be n / 2
// let's say then that the depth of the tree is n
// A tree with depth n has 2 to n nodes
// therefore the number of recursive calls is 2 to n
// The time complexity of the algorithm is:
// O(2 to n * complexity of recursive call)
// the complexity of a recursive call is O(1)
// therefore the time complexity of the algorithm is O(2 to n)

class Solution {
    private int dfs(int i, int[] nums, int[] memo) {
        if (i >= nums.length) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        memo[i] = Math.max(nums[i] + dfs(i + 2, nums, memo), dfs(i + 1, nums, memo));
        return memo[i];
    }

    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = -1;
        }
        return dfs(0, nums, memo);
    }
}
