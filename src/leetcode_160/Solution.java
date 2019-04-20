package leetcode_160;
//Write a program to find the node at which the intersection of two singly linked lists begins.
//
//        For example, the following two linked lists:
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while(a!=b)//пока они не равны друг другу либо не равны нул
        {
            if(a==null)
                a=headB;//если а дошел до конца то переставляем его на начало b и аналогично с a
            else a = a.next;

            if(b==null)
                b = headA;
            else
                b = b.next;
        }
        return a;
    }

}
