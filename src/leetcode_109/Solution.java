package leetcode_109;
//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
//
//        For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//        Example:
//
//        Given the sorted linked list: [-10,-3,0,5,9],
//
//        One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//
//        0
//        / \
//        -3   9
//        /   /
//        -10  5
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST33(head,null);
    }
    public TreeNode sortedListToBST33(ListNode head,ListNode tail) {

        ListNode slow = head;
        ListNode fast = head;
        if(head==tail)
            return null;

        while(fast!=tail&&fast.next!=tail)
        {
            slow=slow.next;
            fast = fast.next.next;//ищем середину
        }
        TreeNode thead = new TreeNode(slow.val);//корень и рекурсивно для левого и правого края списка
        thead.left = sortedListToBST33(head,slow);
        thead.right = sortedListToBST33(slow.next,tail);
        return thead;
    }

}
