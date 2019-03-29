package leetcode_103;
//Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
//
//        For example:
//        Given binary tree [3,9,20,null,null,15,7],
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        return its zigzag level order traversal as:
//        [
//        [3],
//        [20,9],
//        [15,7]
//        ]

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
class Solution {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        TreeNode n = root;
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        s1.push(n);
        while (!s1.empty() || !s2.empty()) {
            List<Integer> current = new ArrayList<>();
            while (!s1.empty()) {
                n = s1.pop();//  в первый стэк заносим слева направо
                current.add(n.val);
                if (n.left != null) s2.push(n.left);
                if (n.right != null) s2.push(n.right);
            }
            if (current.size() != 0)
                res.add(current);
            List<Integer> current2 = new ArrayList<>();
            while (!s2.empty()) {
                n = s2.pop();// во второй стэк заносим справа налево
                current2.add(n.val);
                if (n.right != null) s1.push(n.right);
                if (n.left != null) s1.push(n.left);
            }
            if (current2.size() != 0)
                res.add(current2);

        }
        return res;


    }

    public static void traverse(List<List<Integer>> res, int level, LinkedList<TreeNode> queue) {
        LinkedList<TreeNode> nextQ = new LinkedList<>();
        List<Integer> current = new ArrayList<>();
        if (level % 2 == 0) {
            while (!queue.isEmpty()) {
                TreeNode n = queue.poll();
                nextQ.offerFirst(n.right);
                nextQ.offerFirst(n.left);
                current.add(n.val);
            }
            res.add(current);
            traverse(res, level + 1, nextQ);
        } else {
            while (!queue.isEmpty()) {
                TreeNode n = queue.poll();
                if (n == null)
                    continue;
                nextQ.offerFirst(n.left);
                nextQ.offerFirst(n.right);
                current.add(n.val);
            }
            res.add(current);
            traverse(res, level + 1, nextQ);
        }
    }
}
