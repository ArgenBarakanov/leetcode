package repeat.tree.leetcode_101;

import repeat.tree.leetcode.tree.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return dfs(root,root);
    }

    public boolean dfs(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if((p==null || q == null)) return false;
        if(p.val != q.val) return false;
        return dfs(p.left, q.right)&&dfs(p.right,q.left);
    }
}
