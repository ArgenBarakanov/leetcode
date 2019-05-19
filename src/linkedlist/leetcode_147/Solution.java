package linkedlist.leetcode_147;
//Algorithm of Insertion Sort:
//
//        Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
//        At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
//        It repeats until no input elements remain.

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode helper = new ListNode(0);
        ListNode prev = helper;
        ListNode current = head;
        while(current!=null){
            prev = helper;//каждый раз идем в начало
            while(prev.next!=null&&prev.next.val<current.val)//идем по отсортированному пока не выполнится условие
            {
                prev = prev.next;
            }
            ListNode next = current.next;//сохраняем следующий а этот переносим в отсортированный.на рисунке вспомню
            current.next = prev.next;
            prev.next = current;
            current = next;
        }
        return helper.next;
    }
}

 class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

