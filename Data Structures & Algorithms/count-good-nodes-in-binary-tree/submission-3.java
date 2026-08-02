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
    private record Pair(TreeNode n, Integer m){};

    public int goodNodes(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, Integer.MIN_VALUE));
        int res = 0;

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            if (pair.n != null) {
                int max = pair.m;
                if (pair.n.val >= pair.m) {
                    res++;
                    max = pair.n.val;
                }
                q.offer(new Pair(pair.n.left, max));
                q.offer(new Pair(pair.n.right, max));
            }
        }
        return res;
    }
}
