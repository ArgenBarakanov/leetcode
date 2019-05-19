package tree.leetcode_107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size>0)//обычный bfs но каждый уровень записываем в начало
            {
                TreeNode current = queue.poll();
                size--;
                if(current.left!=null)queue.offer(current.left);
                if(current.right!=null)queue.offer(current.right);
                list.add(current.val);
            }
            res.add(0,list);
        }
        return res;
    }
}
