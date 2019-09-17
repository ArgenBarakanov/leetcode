package bitmanipulation.leetcode_371;
//https://www.youtube.com/watch?time_continue=88&v=qq64FrA2UXQ explanation
//Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
//
//        Example 1:
//
//        Input: a = 1, b = 2
//        Output: 3
public class Solution {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
