package tree.leetcode_110;
//Given a binary tree, determine if it is height-balanced.
//
//        For this problem, a height-balanced binary tree is defined as:
//
//        a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//        Example 1:
//
//        Given the following tree [3,9,20,null,null,15,7]:
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
public class Solution {
    public  boolean res = true;//любой вызов функции может изменить
    public boolean isBalanced(TreeNode root) {

        depth(root);
        return res;
    }
    public int depth(TreeNode root){
        if(root==null)
            return 0;
        int l = depth(root.left);//глубина левого и правого поддерева
        int r = depth(root.right);
        if(Math.abs(l-r)>1)//если они отличаются более чем на 1 то бракуем это дерево
            res=false;
        return 1+Math.max(l,r);//текущий узел плюс максимальная высота левого или праовго поддерева

    }
}
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
