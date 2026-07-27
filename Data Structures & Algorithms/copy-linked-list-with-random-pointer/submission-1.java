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
        
        Node copyNode = new Node(head.val);
        visited.put(node, copyNode);
        Node copyHead = copyNode;

        while (node != null) {
            copyNode.val = node.val;
            if (node.next != null) {
                if (visited.containsKey(node.next)) {
                    copyNode.next = visited.get(node.next);
                } else {
                    Node copyNextNode = new Node(node.next.val);
                    copyNode.next = copyNextNode;
                    visited.put(node.next, copyNextNode);
                }
            }
            if (node.random != null) {
                if (visited.containsKey(node.random)) {
                    copyNode.random = visited.get(node.random);
                } else {
                    Node copyRandomNode = new Node(node.random.val);
                    copyNode.random = copyRandomNode;
                    visited.put(node.random, copyRandomNode);
                }
            }
            node = node.next;
            copyNode = copyNode.next;
        }
        return copyHead;
    }
}
