package leetcode_114;
//
//Given a binary tree, flatten it to a linked list in-place.
//
//        For example, given the following tree:
//
//        1
//        / \
//        2   5
//        / \   \
//        3   4   6
//        The flattened tree should look like:
//
//        1
//        \
//        2
//        \
//        3
//        \
//        4
//        \
//        5
//        \
//        6
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public static void flatten(TreeNode root) {
        if(root==null)
            return;
        flatten(root.left);//выпрямляем левое крыло
        flatten(root.right);//выпрямляем правое крыло
        TreeNode left = root.left;//сохранили их в временные переменные
        TreeNode right = root.right;
        root.left = null;//левое приравниваем к нулю а правое к левому
        root.right = left;
        while (root.right != null) {

            root = root.right;//спускаемся по правому крылу до упора и присобачим правое крыло
        }
        root.right = right;
    }

}