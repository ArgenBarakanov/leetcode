package dynamic.leetcode_95;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new ArrayList<>();
        return getTrees(1,n);
    }

    public List<TreeNode> getTrees(int start,int end ){
        List<TreeNode> list = new ArrayList<>();
        if(start>end){
            list.add(null);
            return list;
        }
        if(start==end)
        {
            list.add(new TreeNode(start));
            return list;
        }

        for(int i = start;i<=end;i++){//нарисовать и вывести алгоритм легко
            List<TreeNode> left = getTrees(start,i-1);
            List<TreeNode> right = getTrees(i+1,end);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
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
