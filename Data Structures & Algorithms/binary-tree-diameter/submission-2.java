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
    private int[] rec(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int lHeight = rec(root.left)[0];
        int rHeight = rec(root.right)[0];
        return new int[] { 1 + Math.max(lHeight, rHeight), lHeight + rHeight };
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] lRec = rec(root.left);
        int[] rRec = rec(root.right);

        return Math.max(lRec[0] + rRec[0],
            Math.max(lRec[1], rRec[1]));
    }
}
