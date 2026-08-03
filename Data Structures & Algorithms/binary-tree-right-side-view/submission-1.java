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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> dq = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();

        dq.offerLast(root);

        while (!dq.isEmpty()) {
            res.add(dq.peekLast().val);
            while (!dq.isEmpty()) {
                q.offer(dq.poll());
            }
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    dq.offerLast(node.left);
                }
                if (node.right != null) {
                    dq.offerLast(node.right);
                }
            }
        }
        return res;
    }
}
