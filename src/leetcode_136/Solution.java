package leetcode_136;
//Given a non-empty array of integers, every element appears twice except for one. Find that single one.
//
//        Note:
//
//        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
//        Example 1:
//
//        Input: [2,2,1]
//        Output: 1
public class Solution {
   // known that A XOR A = 0 and the XOR operator is commutative, the solution will be very straightforward.
   public static  int singleNumber(int[] array){
       int res=0;
       for(int i=0;i<array.length;i++)
       {
           res = res^array[i];
       }
       return res;
   }

}
