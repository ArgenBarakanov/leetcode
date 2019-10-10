package algorithms.string_primitive_integer.conext_4october.leetcode_1207;

import java.util.*;

public class Solution1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> occurences = new HashMap<>();
        for(Integer i:arr){
            if(!occurences.containsKey(i))occurences.put(i,0);
            occurences.put(i,occurences.get(i)+1);
        }
        for(Integer i : occurences.values()){
            if(set.contains(i))return false;
            set.add(i);
        }
        return true;
    }
}
