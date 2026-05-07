/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * [0, 1, 2, 3, 4, 5, 6]
 *
 * [0, 1, 2, 3, 4, 5]
 */

class Solution {
    public void reorderList(ListNode head) {

        // find the half
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // revert the second half
        ListNode curr = slow.next;
        ListNode prev = slow;

        // avoid cycle
        prev.next = null;
        
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // re-order the two halves
        ListNode first = head;
        ListNode last = prev;
        while (last != null && first != null) {
            ListNode t1 = first.next;
            first.next = last;
            first = t1;

            if (last.next != null) {
                ListNode t2 = last.next;
                last.next = first;
                last = t2;
            }
        }
    }
}
