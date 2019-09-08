package array.leetcode_448;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i:nums)set.add(i);
        for(int i=1;i<=nums.length;i++){
            if(!set.contains(i))list.add(i);
        }
        return list;
    }
}
