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

// Iterative DFS
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> ps = new Stack<>();
        Stack<TreeNode> qs = new Stack<>();

        if (p == null && q == null) {
            return true;
        }

        ps.push(p);
        qs.push(q);

        while (!ps.isEmpty() && !qs.isEmpty()) {
            TreeNode pn = ps.pop();
            TreeNode qn = qs.pop();

            if (pn == null && qn == null) {
                continue;
            }
            if (pn == null || qn == null) {
                return false;
            }
            
            if (pn.val != qn.val) {
                return false;
            }

            ps.push(pn.left);
            qs.push(qn.left);
            ps.push(pn.right);
            qs.push(qn.right);
        }
        return true;
    }
}
