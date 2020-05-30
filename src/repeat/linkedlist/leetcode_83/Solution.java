package repeat.linkedlist.leetcode_83;

import repeat.linkedlist.util.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
       ListNode response = new ListNode(-1);
        response.next = head;
      ListNode worker = head;
        while (worker.next != null){
            if(worker.next.val != worker.val){
                worker = worker.next;
            }else {
                worker.next = worker.next.next;
            }
        }
        return response.next;
    }
}
