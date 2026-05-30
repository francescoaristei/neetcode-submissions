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
    private boolean left(int val, TreeNode leftChild) {
        if (leftChild == null) {
            return true;
        }
        if (leftChild.val >= val) {
            return false;
        }

        return left(val, leftChild.left) && left(val, leftChild.right);
    }

    private boolean right(int val, TreeNode rightChild) {
        if (rightChild == null) {
            return true;
        }
        if (rightChild.val <= val) {
            return false;
        }

        return right(val, rightChild.left) && right(val, rightChild.right);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!left(root.val, root.left) || !right(root.val, root.right)) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
}
