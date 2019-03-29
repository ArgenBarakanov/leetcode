package leetcode_142;
//Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
//        To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
//
//        Note: Do not modify the linked list.
//
//
//
//        Example 1:
//
//        Input: head = [3,2,0,-4], pos = 1
//        Output: tail connects to node index 1
//        Explanation: There is a cycle in the linked list, where tail connects to the second node.
class ListNode {
    int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
      }
  }

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null)//один бежит в два раза быстрее и такм образом делает круг и встречает медленного
        {
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast)
                break;
        }
        if(slow!=fast)//если быстрый дошел до конца то медленный окажется на полпути и нет цикла
            return null;
        ListNode curr = head;
        while (curr != fast) {//двигаемся пока не станут равны
            curr = curr.next;
            fast = fast.next;
        }
        return curr;
    }
}