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
    public boolean isValidBST(TreeNode root) {
        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[]{root, 1001, -1001});
        while (!q.isEmpty()) {
            Object[] arr = q.poll();
            TreeNode node = (TreeNode) arr[0];
            Integer max = (Integer) arr[1];
            Integer min = (Integer) arr[2];
            if (node.val >= max || node.val <= min) {
                return false;
            }
            if (node.left != null) {
                q.offer(new Object[]{node.left, node.val, min});
            }
            if (node.right != null) {
                q.offer(new Object[]{node.right, max, node.val});
            }
        }
        return true;
    }
}
