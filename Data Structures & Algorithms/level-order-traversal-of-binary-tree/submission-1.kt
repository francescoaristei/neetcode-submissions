/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val q = ArrayDeque<TreeNode>()

        if (root == null) {
            return emptyList()
        }

        q.add(root)

        while (!q.isEmpty()) {
            val qSize = q.size
            val valList = mutableListOf<Int>()
            for (i in 0 until qSize) {
                val node = q.removeFirst()
                valList.add(node.`val`)

                if (node.left != null) {
                    q.add(node.left)
                }
                if (node.right != null) {
                    q.add(node.right)
                }
            }
            result.add(valList)
        }
        return result
    }
}
