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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        int counter = 1;

        while (!s.isEmpty() || curr != null) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            TreeNode node = s.pop();
            if (counter == k) {
                return node.val;
            }
            counter++;
            curr = node.right;
        }
        return -1;
    }
}
