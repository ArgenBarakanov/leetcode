package leetcode_92;

//Reverse a linked list from position m to n. Do it in one-pass.
//
// Note: 1 ≤ m ≤ n ≤ length of list.
//
// Example:
//
// Input: 1->2->3->4->5->NULL, m = 2, n = 4
// Output: 1->4->3->2->5->NULL
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int i = 1;
        int j = 1;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode start = null;//начало интервала
        ListNode end = null;//конец интервала
        ListNode first = null;//место обрыва и сварки начала интервала
        ListNode second = null;//место обрыва и сварки конца интервала
        while(head!=null)
        {
            if(i==m-1)
                first=head;
            if(j==n)
                second=head.next;
            if(i==m)
                start=head;
            if(j==n)
                end = head;
            i++;
            j++;
            head=head.next;
        }
        ListNode[] mas = reverseList(start,end);
        if(m==1)
        {
            dummy.next=mas[0];//склеиваем
            mas[1].next=second;
            return dummy.next;
        }
        first.next=mas[0];
        mas[1].next=second;

        return dummy.next;
    }
    public ListNode[] reverseList(ListNode head,ListNode tail) {
        ListNode next = head;
        ListNode end = head;
        ListNode prev = null;
        while(next!=null)//не помню. с рисунком смогу воссоздать
        {
            head = next;
            next = next.next;
            head.next=prev;
            prev=head;
            if(prev==tail)
                break;
        }
        ListNode[] listNodes = {prev,end};
        return listNodes;
    }
}
