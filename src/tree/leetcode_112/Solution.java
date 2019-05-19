package tree.leetcode_112;
//Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
//
//        Note: A leaf is a node with no children.
//
//        Example:
//
//        Given the below binary tree and sum = 22
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        return hasPathSum2(root,sum,0);
    }

    public boolean hasPathSum2(TreeNode root, int sum,int current) {
        if(root==null)
            return false;//если нул то вернем
        if(root.left==null&&root.right==null)//если это лист то вернем сумма + текущий равно ли сумме?
            return current+root.val==sum;
        //иначе рекурсивно далее для обоих поддеревьев
        return hasPathSum2(root.left,sum,current+root.val)||hasPathSum2(root.right,sum,current+root.val);
    }
}
