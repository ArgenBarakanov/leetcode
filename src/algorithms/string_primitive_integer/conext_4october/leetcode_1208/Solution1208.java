package algorithms.string_primitive_integer.conext_4october.leetcode_1208;

public class Solution1208 {
    public  static int equalSubstring(String s, String t, int maxCost) {
     int[] diff = new int[s.length()];
     for(int i =0;i<s.length();i++){
         diff[i] = Math.abs(s.charAt(i)-t.charAt(i));

     }
     int i=0,j=0,cost = 0,res = 0;
     while(i<diff.length){
           cost += diff[i];
           if(cost>maxCost){
               cost-=diff[j];
               j++;
           }
           res = Math.max(res,i-j+1);
           i++;
     }
     return res;
    }
}
