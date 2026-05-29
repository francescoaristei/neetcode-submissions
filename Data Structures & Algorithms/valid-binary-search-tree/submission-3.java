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
 * Idea:
 * In a Binary Search Tree, if I do a in-order traversal of the tree
 * I will have all the values in ascending order: 1, 2, 4, 5, 7, 9...
 * If is not a valid Binary Search Tree than the resulting series of the
 * values will not possess this property.
 * To check if the series of values is ordered I can check given a number
 * if the number before is smaller and the number after is bigger.
 */

class Solution {
    List<Integer> values = new ArrayList<>();

    public void rec(TreeNode root) {
        if (root == null) {
            return;
        }
        isValidBST(root.left);
        values.add(root.val);
        isValidBST(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        rec(root);
        if (values.size() == 1) {
            return true;
        }
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i + 1) <= values.get(i)) {
                return false;
            }
        }
        return true;
    }
}
