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
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> oldToNew = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        oldToNew.put(node, new Node(node.val));

        while(!q.isEmpty()) {
            Node n = q.poll();

            for (Node oldne: n.neighbors) {
                if (!oldToNew.containsKey(oldne)) {
                    oldToNew.put(oldne, new Node(oldne.val));
                    q.offer(oldne);
                }
                oldToNew.get(n).neighbors.add(oldToNew.get(oldne));
            }
        }
        return oldToNew.get(node);
    }
}