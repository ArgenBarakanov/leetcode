package tree.leetcode_129;
//Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
//
//        An example is the root-to-leaf path 1->2->3 which represents the number 123.
//
//        Find the total sum of all root-to-leaf numbers.
//
//        Note: A leaf is a node with no children.
//
//        Example:
//
//        Input: [1,2,3]
//        1
//        / \
//        2   3
//        Output: 25
//        Explanation:
//        The root-to-leaf path 1->2 represents the number 12.
//        The root-to-leaf path 1->3 represents the number 13.
//        Therefore, sum = 12 + 13 = 25.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public  int sumNumbers(TreeNode root) {

        return sumNumbers2(root,0);
    }
    public int sumNumbers2(TreeNode root,int currentsum) {
        if(root==null)
            return 0;//если корня нет то это 0
        if(root.left==null&&root.right==null)
            return currentsum*10+root.val;//если это конечный лист то вернем сумму или же нынешнюю сумму умножаем на 10 и прибавить сумму каждой ветки
        return sumNumbers2(root.left,currentsum*10+root.val)+sumNumbers2(root.right,currentsum*10+root.val);
    }
}
