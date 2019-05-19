package linkedlist.leetcode_21;

//Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
//
//        Example:
//
//        Input: 1->2->4, 1->3->4
//        Output: 1->1->2->3->4->4
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }

        if (l2 == null){
            return l1;
        }

        if( l1.val < l2.val){//выбираем меньшее
            l1.next = mergeTwoLists(l1.next, l2); //и отправляем  два уза рекурсивно дальше
            return l1;//вернем ссылку на меньший
        }

        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
