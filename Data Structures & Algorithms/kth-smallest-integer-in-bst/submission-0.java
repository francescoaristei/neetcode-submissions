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
    private List<TreeNode> nodes = new ArrayList<>();

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);

        nodes.add(node);

        inOrder(node.right);

    }

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return nodes.get(k - 1).val;
    }
}
