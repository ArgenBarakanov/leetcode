package repeat.tree.leetcode_98;

import repeat.tree.leetcode.tree.TreeNode;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }

    public boolean helper(TreeNode root, Integer lower, Integer upper){
        if(root == null) return true;
        if(lower != null && root.val <= lower) return false;
        if(upper != null && root.val >= upper) return false;

        return helper(root.left, lower, root.val) && helper(root.right, root.val, upper);
    }
    // нарисуй дерево 5 - 10 - 15
    //                        9  20
}
