/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return emptyList()
        } 
        var result: MutableList<List<Int>> = mutableListOf()
        var counter = 0
        var levelMap = mutableMapOf<Int,List<TreeNode>>()
        levelMap[counter] = listOf(root)

        while (levelMap.containsKey(counter) && !levelMap[counter]!!.isEmpty()) {
            var nodeList: MutableList<TreeNode> = mutableListOf()
            var valList: MutableList<Int> = mutableListOf()
            val temp = levelMap[counter]!!
            for (node in temp) {
                valList.add(node.`val`)
                val left = node.left;
                if (left != null) {
                    nodeList.add(left)
                }
                val right = node.right;
                if (right != null) {
                    nodeList.add(right)
                }
            }
            levelMap[++counter] = nodeList
            result.add(valList)
        }
        return result
    }
}
