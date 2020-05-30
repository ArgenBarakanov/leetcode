package repeat.linkedlist.leetcode_142;
//x - distance from start to loop start
//y - from loop start to pointers intersections
//z - from intersection to loop start
// первый поинтер прошел x + y + z + y а второй медленный x + y
// так как первый идет со скоростью вдвое меньшей то он пройдет вдвое меньше расстояние
// отсюда x = z
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast)
                break;
        }
        if(slow!=fast)
            return null;
        ListNode curr = head;
        while (curr != fast) {
            curr = curr.next;
            fast = fast.next;
        }
        return curr;
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
