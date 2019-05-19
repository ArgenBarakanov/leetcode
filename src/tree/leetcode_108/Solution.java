package tree.leetcode_108;
//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//
//        For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//        Example:
//
//        Given the sorted array: [-10,-3,0,5,9],
//
//        One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//
//        0
//        / \
//        -3   9
//        /   /
//        -10  5
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if(num==null||num.length==0)
            return null;
        return sortedArrayToBST2(num,0,num.length-1);
    }

    public TreeNode sortedArrayToBST2(int[] num,int low,int high) {
        if(low>high)
            return null;
        else
        {
            int mid = (low+high)/2;//бинарный поиск .ищем середину .  создаем узел и присобачиваем
            //слева и справа рекурсивным вызовом функции для левой и правой части списка
            TreeNode root = new TreeNode(num[mid]);
            root.left=sortedArrayToBST2(num,low,mid-1);
            root.right=sortedArrayToBST2(num,mid+1,high);
            return root;
        }
    }
}
