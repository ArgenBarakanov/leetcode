package string.leetcode_67;

//Given two binary strings, return their sum (also a binary string).
//
//        The input strings are both non-empty and contains only characters 1 or 0.
//
//        Example 1:
//
//        Input: a = "11", b = "1"
//        Output: "100"
public class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while(i>=0||j>=0){
            int sum = carry;
            if(i>=0)sum = sum + a.charAt(i--)-'0';//если индекс не вышел за пределы то берем его как символ
            if(j>=0)sum = sum +b.charAt(j--)-'0';
            stringBuilder.insert(0,sum%2);//втсавляем в начало каждый раз
            carry = sum/2;//остаток для переноса
        }
        if(carry!=0)stringBuilder.insert(0,carry%2);
        return stringBuilder.toString();
    }
}
