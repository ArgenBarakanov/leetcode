package tree.leetcode_257;

import java.util.ArrayList;
import java.util.List;

public class Solution {
     public static List<String> binaryTreePaths(TreeNode root) {
         List<String> res = new ArrayList<>();
         if(root==null)
             return res;
         String str = "";
         binaryTreePathshelper(root,str,res);
         return res;
     }
     public static void binaryTreePathshelper(TreeNode node,String str,List<String> list) {
         if(node==null)
             return;//если нул то ничего не делаем
         if(node.left==null&&node.right==null)
         {
             str+=node.val;//если это лист то заносим его в путь и весь путь в результат
             list.add(str);
         }
         else
         {
             str=str+node.val+"->";//если же не лист то заносим его в путь и отправляем рекурсию дальше к правому и левому потомку
             binaryTreePathshelper(node.left,new String(str),list);
             binaryTreePathshelper(node.right,new String(str),list);
         }
     }
}
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
