package repeat.linkedlist.leetcode_141;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        if(head.next==null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast)
                break;

        }
        return fast==slow;
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
