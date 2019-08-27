package linkedlist.leetcode_203;
//Remove all elements from a linked list of integers that have value val.
//
//        Example:
//
//        Input:  1->2->6->3->4->5->6, val = 6
//        Output: 1->2->3->4->5
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode res = dum;
        while(dum.next!=null)
        {
            if(dum.next.val!=val)//если у следующего значение не равно целевому то идем к нему иначе как бы перепрыгиваем черз него
            {
                dum = dum.next;
            }
            else
            {
                dum.next = dum.next.next;
            }
        }
        return res.next;
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
