package linkedlist.leetcode_82;

//Given a sorted linked list, delete all duplicates such that each element appear only once.
//
// Example 1:
//
// Input: 1->1->2
// Output: 1->2
// Example 2:
//
// Input: 1->1->2->3->3
// Output: 1->2->3
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if(head==null)//если переданный узел равен нулю то вернем нуль
            return null;
        if(head.next==null)//если узел последний то его и вернем
            return head;
        if(head.next.val!=head.val)//если последующий неравен данному то рекуивно вызываем функцию для следующего
        {
            head.next = deleteDuplicates(head.next);
            return head;
        }
        int val = head.val;
        while(head.val==val)//перебираем списко пока не найдем отличный от данного элемент
        {
            head = head.next;
            if(head==null)
                return null;
        }
        return deleteDuplicates(head);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
