package binarysearch.leetcode_367;
//Given a positive integer num, write a function which returns True if num is a perfect square else False.
//
//        Note: Do not use any built-in library function such as sqrt.
public class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high)/2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }
}
