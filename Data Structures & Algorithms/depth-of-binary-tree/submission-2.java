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

// BFS (queue)
class Solution {
    public int maxDepth(TreeNode root) {
        int max = 0;
        if (root == null) {
            return max;
        }

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 1));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            Integer depth = pair.getValue();
            if (depth > max) {
                max = depth;
            }
            if (node.left != null) {
                queue.offer(new Pair<>(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, depth + 1));
            }
        }
        return max;
    }
}
