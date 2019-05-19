package hashtable.leetcode_187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> visited = new HashSet<>();
        Set<String> res = new HashSet<>();
        for(int i=0;i+9<s.length();i++){
            String word = s.substring(i,i+10);
            if(!visited.add(word))res.add(word);//заносим все значения в посещенные. если есть повторение то заносим его в результат
        }
        return new ArrayList<String>(res);
    }
}
