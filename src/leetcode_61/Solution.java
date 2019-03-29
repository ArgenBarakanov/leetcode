package leetcode_61;

//Given a linked list, rotate the list to the right by k places, where k is non-negative.
//
//        Example 1:
//
//        Input: 1->2->3->4->5->NULL, k = 2
//        Output: 4->5->1->2->3->NULL
//        Explanation:
//        rotate 1 steps to the right: 5->1->2->3->4->NULL
//        rotate 2 steps to the right: 4->5->1->2->3->NULL
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0||head==null)
            return head;
        ListNode index = head;
        int len = 1;
        while(index.next!=null)
        {
            index=index.next;
            len++;//считаем длину списка
        }
        index.next=head;
        k = k%len;//надо отсупить от конца
        ListNode current = head;
        int i = 1;
        while(i<len-k)
        {
            current = current.next;
            i++;
        }
        head = current.next;//там где стопнулись делаем круг
        current.next=null;//и в нужном месте размыкаем кругу

        return head;
    }
}
