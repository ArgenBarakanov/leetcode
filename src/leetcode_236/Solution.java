package leetcode_236;
//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
//
//        According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
//
//        Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        if(root.val==p.val||root.val==q.val)return root;//если кто из них равен то вернем его
        TreeNode left = lowestCommonAncestor(root.left,p,q);//ищем для левого
        TreeNode right = lowestCommonAncestor(root.right,p,q);//ищем для правого
        if(right!=null&&left!=null)return root;//если оба неравны нул  то вернем текущего
        return right==null?left:right;//если же оба в каком то левом или правом поддереве то вернем то что не равно нул
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
