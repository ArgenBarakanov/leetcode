package leetcode_199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//199. Binary Tree Right Side View
//        Medium
//
//        965
//
//        40
//
//        Favorite
//
//        Share
//        Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//
//        Example:
//
//        Input: [1,2,3,null,5,null,4]
//        Output: [1, 3, 4]
//        Explanation:
//
//        1            <---
//        /   \
//        2     3         <---
//        \     \
//        5     4       <---
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public List<Integer> rightSideView(TreeNode root) {//обычный bfs но в конце каждого уровня заносим в результат значение крайнего правого узла
        Queue<TreeNode> queue = new LinkedList();
        List<Integer> res = new ArrayList<>();
        if(root==null)return res;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0)
            {
                TreeNode current = queue.poll();
                if(current.left!=null)
                    queue.add(current.left);
                if(current.right!=null)
                    queue.add(current.right);
                if(size==1){res.add(current.val);}

                size--;
            }
        }
        return res;
    }
}
