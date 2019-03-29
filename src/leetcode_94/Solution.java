package leetcode_94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//Given a binary tree, return the inorder traversal of its nodes' values.
//
// Example:
//
// Input: [1,null,2,3]
// 1
// \
// 2
// /
// 3
//
// Output: [1,3,2]
// Follow up: Recursive solution is trivial, could you do it iteratively?
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {//рекурсивно это означает пройти левое поддерево корень и правое поддерево
        List<Integer> list = new ArrayList<>();//идея в том чтобы до упора идти по левому краю и если больше нет левых то вытаскиваем из стэка и уже у него идет по левому краю
        if(root==null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null)
        {
            stack.push(root);
            root=root.left;
        }
        while (!stack.empty())
        {
            TreeNode curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
            while(curr!=null)
            {
                stack.push(curr);
                curr=curr.left;
            }
        }

        return list;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
