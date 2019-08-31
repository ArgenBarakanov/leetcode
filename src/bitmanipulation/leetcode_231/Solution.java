package bitmanipulation.leetcode_231;
//Given an integer, write a function to determine if it is a power of two.
//
//        Example 1:
//
//        Input: 1
//        Output: true
//        Explanation: 20 = 1
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)
            return false;
        String s = Integer.toBinaryString(n);//в двоичное представление и если всего одна единица то это степень двойки
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')
                count++;
        }
        return count==1;
    }
}
