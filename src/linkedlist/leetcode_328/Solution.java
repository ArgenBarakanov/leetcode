package linkedlist.leetcode_328;
//Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
//
//        You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
//
//        Example 1:
//
//        Input: 1->2->3->4->5->NULL
//        Output: 1->3->5->2->4->NULL
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head,even = odd.next,evenHead = even;//запоминаем первый четный
        while(even!=null&&even.next!=null){//двинаем четный и нечетный одновременно
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;//присобачили четный и нечетный
        return head;
    }
}
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }