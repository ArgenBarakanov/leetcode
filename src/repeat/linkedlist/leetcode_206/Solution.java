package repeat.linkedlist.leetcode_206;


import repeat.linkedlist.util.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode temp = null;
        ListNode next = null;
        while (head != null){
            temp = head.next;
            head.next = next;
            next = head;
            head = temp;
        }
        return next;
    }

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode response = new Solution().reverseList(listNode1);
        System.out.println(response.val);
    }
}
