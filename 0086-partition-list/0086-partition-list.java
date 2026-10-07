class Solution {
    public ListNode partition(ListNode head, int x) {
        // Dummy head nodes to form two separate linked lists
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);

        ListNode less = lessHead;
        ListNode greater = greaterHead;

        // Traverse the original list and split nodes
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        // Terminate the greater list to prevent cycles
        greater.next = null;

        // Connect the 'less' list with the 'greater' list
        less.next = greaterHead.next;

        return lessHead.next;
    }
}