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

    private boolean rec(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        if (root.val != subRoot.val) {
            return false;
        }

        return rec(root.left, subRoot.left) && rec(root.right, subRoot.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        Queue<TreeNode> rootQueue = new LinkedList<>();
        rootQueue.offer(root);
        while (!rootQueue.isEmpty()) {
            int size = rootQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = rootQueue.poll();
                if (rec(node, subRoot)) {
                    return true;
                }
                if (node.left != null) {
                    rootQueue.offer(node.left);
                }
                if (node.right != null) {
                    rootQueue.offer(node.right);
                }
            }
        }
        return false;
    }
}
