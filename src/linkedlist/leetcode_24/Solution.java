package linkedlist.leetcode_24;

//Given a linked list, swap every two adjacent nodes and return its head.
//
//        You may not modify the values in the list's nodes, only nodes itself may be changed.
//
//
//
//        Example:
//
//        Given 1->2->3->4, you should return the list as 2->1->4->3.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)//базовый случай. лист равен нулю либо его сосед равен нулю
            return head;
        else
        {
            ListNode n = head.next;//если жне нет то берем второй узел. меняем у него указатель на первого а первому в качестве соседа указываем рекурсивно следующую пару и вернем второй узел
            head.next=swapPairs(head.next.next);
            n.next=head;
            return n;
        }
    }
}
