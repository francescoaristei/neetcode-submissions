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
    private int val;
    private int counter = 1;

    private void inOrder(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        inOrder(node.left, k);

        if (counter == k) {
            val = node.val;
        }
        counter++;
        inOrder(node.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return val;
    }
}
