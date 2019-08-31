package linkedlist.leetcode_234;

import java.util.ArrayList;
import java.util.List;
//Given a singly linked list, determine if it is a palindrome.
//
//        Example 1:
//
//        Input: 1->2
//        Output: false
//        Example 2:
//
//        Input: 1->2->2->1
//        Output: true
public class Solution {
    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        if(list.size()==0||list.size()==1)return true;
        for(int i =0;i<list.size();i++){//занесли в арайлист и проверили на симметрию
            if(!list.get(i).equals(list.get(list.size()-1-i)))return false;
        }
        return true;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
