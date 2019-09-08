package bitmanipulation.leetcode_191;
//Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
public class Solution {
    public int hammingWeight(int n) {
        String  s = Integer.toBinaryString(n);
        int count =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')
                count++;
        }
        return count;
    }
}
