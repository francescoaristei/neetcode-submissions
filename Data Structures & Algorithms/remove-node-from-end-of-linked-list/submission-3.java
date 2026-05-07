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
    private ListNode rec(ListNode node, int n) {
        if (node == null) {
            return node;
        }

        node = rec(node.next, n);

        if (n == 0) {
            node.next = node.next.next;
        }

        n--;

        return node;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        ListNode node = head;
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }

        int counter = 0;
        ListNode prev = null;
        node = head;
        while (counter < length - n) {
            prev = node;
            node = node.next;
            counter++;
        }
        if (counter == 0) {
            head = head.next;
        } else {
            prev.next = prev.next.next;
        }

        return head;
    }
}
