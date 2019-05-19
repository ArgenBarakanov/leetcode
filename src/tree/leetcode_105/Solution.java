package tree.leetcode_105;

//Given preorder and inorder traversal of a tree, construct the binary tree.
//
// Note:
// You may assume that duplicates do not exist in the tree.
//
// For example, given
//
// preorder = [3,9,20,15,7]
// inorder = [9,3,15,20,7]
// Return the following binary tree:
//
// 3
// / \
// 9 20
// / \
// 15 7
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree2(0,0,inorder.length-1,preorder,inorder);
    }
    public TreeNode buildTree2(int prestart,int instart,int inend,int[] preorder, int[] inorder) {
        if(prestart>preorder.length-1||instart>inend)
            return null;
        TreeNode root = new TreeNode(preorder[prestart]);//в preorder корень идет первым всегда
        int partition = instart;
        for(int i = instart;i<inorder.length;i++)
        {
            if(inorder[i]==root.val)
                partition = i;//ищем корень в инордере
        }

        root.left = buildTree2(prestart+1,instart,partition-1,preorder,inorder);//рекурсивно для обеих ветвей ищем их корни
        root.right = buildTree2(prestart-instart+partition+1,partition+1,inend,preorder,inorder);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}