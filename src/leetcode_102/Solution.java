package leetcode_102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
// For example:
// Given binary tree [3,9,20,null,null,15,7],
// 3
// / \
// 9 20
// / \
// 15 7
// return its level order traversal as:
// [
// [3],
// [9,20],
// [15,7]
// ]
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {//стандартный обход в ширину
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size>0)//обход текущего уровня
            {
                TreeNode current = queue.poll();
                size--;
                if(current.left!=null)queue.offer(current.left);
                if(current.right!=null)queue.offer(current.right);
                list.add(current.val);
            }
            res.add(list);
        }
        return res;
    }
}
