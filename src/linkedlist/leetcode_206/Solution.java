package linkedlist.leetcode_206;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        ListNode next = head;
        ListNode prev = null;
        while(next!=null)
        {
            head = next;//head указывает на тот который скоро повернет свой указатель на предыдущий
            next = next.next;//next становится следующим
            head.next=prev;//head ссылается на предыдущий
            prev=head;//предыдущий становится текущим
        }
        return prev;
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
