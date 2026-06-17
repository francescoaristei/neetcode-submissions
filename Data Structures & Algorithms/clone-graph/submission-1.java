/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node, Node> oldToNew = new HashMap<>();

    private void dfs(Node node) {
        if (!oldToNew.containsKey(node)) {
            oldToNew.put(node, new Node(node.val));
            for (Node ne: node.neighbors) {
                dfs(ne);
                oldToNew.get(node).neighbors.add(oldToNew.get(ne));
            }
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        dfs(node);
        return oldToNew.get(node);
    }
}