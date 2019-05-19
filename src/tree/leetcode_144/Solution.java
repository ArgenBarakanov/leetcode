package tree.leetcode_144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//Given a binary tree, return the preorder traversal of its nodes' values.

//        Example:
//
//        Input: [1,null,2,3]
//        1
//        \
//        2
//        /
//        3
//
//        Output: [1,2,3]
//        Follow up: Recursive solution is trivial, could you do it iteratively?

 class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode(int x) { val = x; }
 }

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null)
            return res;
        stack.push(new TreeNode(0));
        while(!stack.empty())
        {
            while(root!=null)//идем к левому потомку насколько это возможно
            {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop().right;//берем у верхнего узла рпавого и у него идем по левой части до упора

        }
        return res;
    }
}

