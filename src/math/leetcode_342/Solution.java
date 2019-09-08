package math.leetcode_342;
//Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
//
//        Example 1:
//
//        Input: 16
//        Output: true
//        Example 2:
//
//        Input: 5
//        Output: false
public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num == 0) {
            return false;
        }
        while(num % 4 == 0) {
            num = num / 4;
        }
        if(num == 1) {
            return true;
        }
        return false;
    }
}
