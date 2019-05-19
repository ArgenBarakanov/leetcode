package linkedlist.leetcode_23;

//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
//
//        Example:
//
//        Input:
//        [
//        1->4->5,
//        1->3->4,
//        2->6
//        ]
//        Output: 1->1->2->3->4->4->5->6
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return sort(lists, 0, lists.length - 1);
    }

    private ListNode sort(ListNode[] lists, int right, int left) {
        if (right >= left) {
            return lists[right];
        }

        int mid = right + (left - right) / 2;//сортировка слиянием
        ListNode node1 = sort(lists, right, mid);
        ListNode node2 = sort(lists, mid + 1, left);
        return merge(node1, node2);//слияние
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;// базовые случаи
        }
        if (node2 == null) {
            return node1;
        }

        if (node1.val < node2.val) {
            node1.next = merge(node1.next, node2);//рекурсивное слияние
            return node1;
        }

        node2.next = merge(node1, node2.next);
        return node2;
    }

}
