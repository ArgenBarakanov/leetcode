package leetcode_116;

//You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
//
//        struct Node {
//        int val;
//        Node *left;
//        Node *right;
//        Node *next;
//        }
//        Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//
//        Initially, all next pointers are set to NULL.

import java.util.LinkedList;
import java.util.Queue;

class TreeLinkNode {
 int val;
 TreeLinkNode left, right, next;
 TreeLinkNode(int x) { val = x; }
 }

public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        TreeLinkNode current ;
        while(!queue.isEmpty())//идея в том чтобы обойти в ширину и на каждом уровне установить указатели
        {
            int size = queue.size();

            while(size>0)
            {
                current = queue.poll();
                size--;
                if(size==0)
                {current.next=null;}
                else {
                    current.next = queue.peek();
                }
                if(current.left!=null)queue.add(current.left);
                if(current.right!=null)queue.add(current.right);
            }
        }
    }
}
