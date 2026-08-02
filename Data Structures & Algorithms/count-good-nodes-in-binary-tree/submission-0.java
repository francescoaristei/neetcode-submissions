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
    private int result;

    private void rec(TreeNode root, int max) {
        if (root != null && root.val >= max) {
            result++;
        }
        if (root != null) {
            rec(root.left, Math.max(max, root.val));
            rec(root.right, Math.max(max, root.val));
        }
    }

    public int goodNodes(TreeNode root) {
        result = 0;
        rec(root, Integer.MIN_VALUE);
        return result;
    }
}
