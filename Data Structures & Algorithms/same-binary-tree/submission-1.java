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

// iterative BFS
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();

        pQueue.offer(p);
        qQueue.offer(q);

        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            int pSize = pQueue.size();
            int qSize = qQueue.size();

            if (pSize != qSize) {
                return false;
            }

            for (int i  = 0; i < pSize; i++) {
                TreeNode pNode = pQueue.poll();
                TreeNode qNode = qQueue.poll();

                if (pNode.val != qNode.val) {
                    return false;
                }
                if (pNode.left == null && qNode.left != null || pNode.left != null && qNode.left == null) {
                    return false;
                }
                if (pNode.right == null && qNode.right != null || pNode.right != null && qNode.right == null) {
                    return false;
                }
                if (pNode.left != null && qNode.left != null) {
                    pQueue.offer(pNode.left);
                    qQueue.offer(qNode.left);
                }
                if (pNode.right != null && qNode.right != null) {
                    pQueue.offer(pNode.right);
                    qQueue.offer(qNode.right);
                }
            }
        }
        return true;
    }
}
