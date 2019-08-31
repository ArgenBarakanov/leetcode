package linkedlist.leetcode_237;
//Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
//
//        Given linked list -- head = [4,5,1,9], which looks like following:
//        Input: head = [4,5,1,9], node = 5
//        Output: [4,1,9]
//        Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.


public class Solution {
    public void deleteNode(ListNode node) {
        while(node.next.next!=null)
        {
            node.val = node.next.val;//вобщем то мы просто сдвигаем значения в узлах вправо и затем последний который дублируется обнуляем. удаления как такогого нет
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
}
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
