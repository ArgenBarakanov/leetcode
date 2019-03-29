package leetcode_106;
//Given inorder and postorder traversal of a tree, construct the binary tree.
//
//        Note:
//        You may assume that duplicates do not exist in the tree.
//
//        For example, given
//
//        inorder = [9,3,15,20,7]
//        postorder = [9,15,7,20,3]
//        Return the following binary tree:
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

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inStart = 0;
        int inEnd = inorder.length - 1;
        int postStart = 0;
        int postEnd = postorder.length - 1;

        return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd,int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd){
            return null;
        }

        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);

        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                k = i;
                break;
            }
        }

        //instart и inend все понятно . для poststart and postend нужно отсчитать кол во элементов в каэждом поддереве
        root.left = buildTree(inorder, inStart, k - 1, postorder, postStart,
                postStart + k - (inStart + 1));

        root.right = buildTree(inorder, k + 1, inEnd, postorder, postEnd-1-inEnd+k, postEnd - 1);


        return root;
    }
}















