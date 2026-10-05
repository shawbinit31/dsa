
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
    public ListNode deleteDuplicates(ListNode head) {
        // Dummy node acts as a safe predecessor to the head
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        while (head != null) {
            // If head is the start of duplicates, skip all nodes with the same value
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Skip all duplicates by linking prev directly to head.next
                prev.next = head.next;
            } else {
                // No duplicate for head, advance prev
                prev = prev.next;
            }
            head = head.next;
        }

        return dummy.next;
    }
}