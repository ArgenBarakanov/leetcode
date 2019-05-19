package tree.leetcode_113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
//        Note: A leaf is a node with no children.
//
//        Example:
//
//        Given the below binary tree and sum = 22,
//
//        5
//        / \
//        4   8
//        /   / \
//        11  13  4
//        /  \    / \
//        7    2  5   1
//        Return:
//
//        [
//        [5,4,11,2],
//        [5,8,4,5]
//        ]
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public  List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        pathSum2(root,sum,list,res);
        return res;
    }

    public void pathSum2(TreeNode root, int sum,List<Integer> current,List<List<Integer>> res) {
        if(root==null)
            return;//базовый случай

        current.add(root.val);//если нет потомков и сумма равна корню то добавляем в конечный результат затем удаляем корень и выходим из функции
        if(root.left==null&&root.right==null&&sum==root.val)
        {
            res.add(new ArrayList<>(current));
            current.remove(current.size()-1);
            return;
        }
        else
        {
            pathSum2(root.left,sum-root.val,current,res);//если же нет то идем дальше по дереву вниз вычитая из суммы корень
            pathSum2(root.right,sum-root.val,current,res);
        }
        current.remove(current.size()-1);
    }
}
