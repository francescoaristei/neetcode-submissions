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
    public int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode, int[]> map = new HashMap<>();
        map.put(null, new int[]{0, 0});
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            if (node.left != null && !map.containsKey(node.left)) {
                stack.push(node.left);
            } else if (node.right != null && !map.containsKey(node.right)) {
                stack.push(node.right);
            } else {
                node = stack.pop();
                int rHeight = map.get(node.right)[0];
                int rDiameter = map.get(node.right)[1];

                int lHeight = map.get(node.left)[0];
                int lDiameter = map.get(node.left)[1];

                int height = 1 + Math.max(rHeight, lHeight);
                int diameter = Math.max(rHeight + lHeight, Math.max(
                    lDiameter, rDiameter));

                map.put(node, new int[]{height, diameter});
            }
        }
        return map.get(root)[1];
    }
}
