package leetcode_260;

import java.util.HashSet;

//Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
//
//        Example:
//
//        Input:  [1,2,1,3,2,5]
//        Output: [3,5]
public class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> h = new HashSet<>();
        for(int n : nums){
            if(h.contains(n)) h.remove(n);//если сет уже содержит то удаляем.те которые встречаются однажды останутся
            else h.add(n);
        }
        Object[] t =h.toArray();
        int[] result = new int[2];
        result[0] = (int)t[0];
        result[1] = (int)t[1];
        return result;
    }
}
