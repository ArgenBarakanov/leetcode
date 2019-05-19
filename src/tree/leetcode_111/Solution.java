package tree.leetcode_111;
//Given a binary tree, find its minimum depth.
//
//        The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//
//        Note: A leaf is a node with no children.
//
//        Example:
//
//        Given binary tree [3,9,20,null,null,15,7],
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Solution {
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;//ноль если нет ничего
        int left = minDepth(root.left);//минимальную высоту каждого поддерева
        int right = minDepth(root.right);
        if(left==0||right==0)
            return 1+Math.max(left,right);//текущий плюс максимум из двух если кто из них равен нуль(т.е. не является листом)
        else
            return 1+Math.min(left,right);//минимум из двух плюс текущий
    }
}
