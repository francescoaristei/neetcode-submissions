/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    record Pair(Integer h, Boolean b) {};

    private Pair rec(TreeNode root) {
        if (root == null) {
            return new Pair(0, true);
        }

        Pair lPair = rec(root.left);
        Pair rPair = rec(root.right);

        if (!lPair.b || !rPair.b) {
            return new Pair(-1, false);
        }

        return new Pair(1 + Math.max(lPair.h, rPair.h), 
            Math.abs(lPair.h - rPair.h) <= 1);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Pair lPair = rec(root.left);
        Pair rPair = rec(root.right);

        return Math.abs(lPair.h - rPair.h) <= 1 && lPair.b && rPair.b;
    }
}
