package leetcode_86;

//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
// You should preserve the original relative order of the nodes in each of the two partitions.
//
// Example:
//
// Input: head = 1->4->3->2->5->2, x = 3
// Output: 1->2->2->4->3->5
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dum = new ListNode(0);//те что меньше
        ListNode dum2 = new ListNode(0);//те что больше
        ListNode current = dum;
        ListNode current2 = dum2;
        while(head!=null)
        {
            if(head.val<x)
            {
                current.next = head;//в зависимости от значения цепляем к нужной половине
                current = current.next;
            }
            else
            {
                current2.next=head;
                current2 = current2.next;
            }
            head = head.next;
        }
        current2.next=null;
        current.next=dum2.next;//соединяем их в точке равной х
        return dum.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
