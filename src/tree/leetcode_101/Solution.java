package tree.leetcode_101;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;//если они равны нул то вернем истину
        if (t1 == null || t2 == null) return false;//если же только один из них равен нул то вернем ложь
        return (t1.val == t2.val)//рекурсивно для следующих поддеревьев
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
}
