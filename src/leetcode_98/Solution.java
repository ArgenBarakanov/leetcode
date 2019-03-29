package leetcode_98;

import java.util.ArrayList;
import java.util.List;

        import java.util.ArrayList;
        import java.util.List;

//Given a binary tree, determine if it is a valid binary search tree (BST).
//
// Assume a BST is defined as follows:
//
// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
// Example 1:
//
// Input:
// 2
// / \
// 1 3
// Output: true
public class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        boolean res = true;
        dfs(list,root);//обходим слева центр напрво и в конце проверяем последовательность элементов
        for(int i = 0;i<list.size()-1;i++){
            if(list.get(i)>=list.get(i+1)){
                res = false;
                break;
            }
        }
        return res;
    }
    public void dfs(List<Integer> list, TreeNode root){
        if(root==null)
            return;
        dfs(list,root.left);
        list.add(root.val);
        dfs(list,root.right);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}