package repeat.linkedlist.leetcode_23;

import repeat.linkedlist.util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {


        //приоритетная очередь сортирует по мере вставки элементы
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for(ListNode node : lists) {
            if(node != null)
                queue.add(node);
        }

        ListNode dummyNode;
        ListNode head = dummyNode =  new ListNode(-1);
        //допустим у нас есть 3 узла 1 2 3 и у 1 следующий это 5 , у нас 2 это 4 , а у 3 это 8
        while(!queue.isEmpty()) {
            ListNode minElement = queue.poll();//вытащили 1
            head.next = minElement;//добавили его в цепочку ответов
            minElement = minElement.next;// минимальный как бы сдвинули на 5 и добавили в очередь 2 3 5
            head = head.next;
            if(minElement != null) {
                queue.add(minElement);
            }
        }
        return dummyNode.next;
    }
}
