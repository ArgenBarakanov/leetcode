package leetcode_222;


//Given a complete binary tree, count the number of nodes.
//
//        Note:
//
//        Definition of a complete binary tree from Wikipedia:
//        In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
//
//        Example:
//
//        Input:
//        1
//        / \
//        2   3
//        / \  /
//        4  5 6
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Solution {
    public int countNodes(TreeNode root) {

        int l = lheight(root);
        int r = rheight(root);
        if(l==r)
        {
            return (1<<l)-1;
        }
        else
            return 1+countNodes(root.left)+countNodes(root.right);

    }
    public int lheight(TreeNode root){

        int res = 0;
        while(root!=null)
        {

            root=root.left;
            res++;
        }
        return res;
    }
    public int rheight(TreeNode root){

        int res = 0;
        while(root!=null)
        {

            root=root.right;
            res++;
        }
        return res;
    }
}
