package repeat.tree.leetcode_100;

import repeat.tree.leetcode.tree.TreeNode;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if((p==null && q != null) || (p!=null && q == null)) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right,q.right);
    }
}