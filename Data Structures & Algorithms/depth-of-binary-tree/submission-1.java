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

// Iterative DFS (stack)
class Solution {
    public int maxDepth(TreeNode root) {
        int max = 0;
        if (root == null) {
            return max;
        }
        Stack<Pair<TreeNode, Integer>> nodesDepths = new Stack<>();
        nodesDepths.push(new Pair(root, 1));
        while (!nodesDepths.isEmpty()) {
            Pair<TreeNode, Integer> nodeDepth = nodesDepths.pop();
            TreeNode node = nodeDepth.getKey();
            Integer depth = nodeDepth.getValue();
            if (depth > max) {
                max = depth;
            }
            if (node.left != null) {
                nodesDepths.push(new Pair(node.left, depth + 1));
            }
            if (node.right != null) {
                nodesDepths.push(new Pair(node.right, depth + 1));
            }
        }
        return max;
    }
}
