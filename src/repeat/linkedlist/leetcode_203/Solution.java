package repeat.linkedlist.leetcode_203;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode response = new ListNode(0);
        response.next = head;
        ListNode worker = response;
        while (worker.next != null) {
            if (worker.next.val != val) {
                worker = worker.next;
            } else {
                worker.next = worker.next.next;
            }
        }
        return response.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
