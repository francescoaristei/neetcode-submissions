/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> visited = new HashMap<>();

        Node node = head;

        while (node != null) {
            if (!visited.containsKey(node)) {
                visited.put(node, new Node(node.val));
            }
            node = node.next;
        }

        node = head;
        while (node != null) {
            Node nnode = visited.get(node);
            nnode.next = node.next == null ? null : visited.get(node.next);
            nnode.random = node.random == null ? null : visited.get(node.random);
            node = node.next;
        }

        return visited.get(head);
    }
}
