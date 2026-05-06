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

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode n1 = head;

        // empty list
        if (n1 == null) {
            return null;
        }

        ListNode n2 = head.next;

        // otherwise you would have a cycle like:
        // given [0, 1, 2, 3]
        // revert [3, 2, 1, 0 -> 1] 0 would still have 1 as next
        n1.next = null;

        while (n2 != null) {
            ListNode temp = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = temp;
        }

        return n1;
    }
}
