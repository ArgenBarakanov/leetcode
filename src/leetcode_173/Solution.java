package leetcode_173;

import java.util.Stack;

//Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
//
//        Calling next() will return the next smallest number in the BST.
public class Solution {
    public class BSTIterator {

        private Stack<TreeNode>stack = new Stack<>();
        public BSTIterator(TreeNode root) {
            ;       push(root);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.empty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode current = stack.pop();
            push(current.right);//праове крыло любого узла
            return current.val;
        }

        public void push(TreeNode root){//до крайнего левого
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
        }
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }