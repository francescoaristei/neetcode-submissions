/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 /*

 [0, 1, 2, 3, 4, 5, 6]
 [6, 5, 4, 3, 2, 1, 0]

 [0, 1, 2, 3, 4, 5, 6]

 [0, 1, 2, 3, 4, 5]

 [0, n-1, 1, n-2, 2, n-3,...,n/2, n - (n/2 + 1)]

 */

class Solution {
    public void reorderList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            nodes.add(node);
            node = node.next;
        }
        int i = 0;
        int j = nodes.size() - 1;
        // [0, 1, 2, 3, 4, 5, 6]
        // [0, 1, 2, 3, 4, 5]
        while (i < j) {
            nodes.get(i).next = nodes.get(j);
            i++;
            nodes.get(j).next = nodes.get(i);
            j--;
        }
        if (nodes.size() % 2 == 0) {
            nodes.get(i).next = null;
        } else {
            nodes.get(j).next = null;
        }
    }
}
