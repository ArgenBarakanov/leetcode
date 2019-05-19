package math.leetcode_172;
//Given an integer n, return the number of trailing zeroes in n!.
//
//        Example 1:
//
//        Input: 3
//        Output: 0
//        Explanation: 3! = 6, no trailing zero.
public class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while(n>0){
            res = res +n/5;//зависит от количества повторений 5.
            n=n/5;
        }
        return res;
    }
}
