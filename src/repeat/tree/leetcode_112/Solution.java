package repeat.tree.leetcode_112;

import repeat.tree.leetcode.tree.TreeNode;

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        return hasPathSum2(root,sum,0);
    }

    public boolean hasPathSum2(TreeNode root, int sum, int current) {
        if(root==null)
            return false;
        if(root.left==null&&root.right==null)
            return current+root.val==sum;
        return hasPathSum2(root.left,sum,current+root.val)||hasPathSum2(root.right,sum,current+root.val);
    }
}
