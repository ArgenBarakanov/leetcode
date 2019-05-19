package linkedlist.leetcode_143;

public class Solution {
    public static void reorderList(ListNode head) {//находим половину. переворачиваем вторую половину и делаем бутерброд
        if(head==null||head.next==null)return;
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2.next!=null&&p2.next.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        p1.next = reverse(p1.next);
        ListNode mid = p1;
        p1 = head;
        p2 = mid.next;
        while(p1!=mid){
            mid.next=p2.next;
            p2.next = p1.next;
            p1.next=p2;
            p1 = p2.next;
            p2 = mid.next;
        }

    }

    public static ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        ListNode next = head;
        while (next!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
