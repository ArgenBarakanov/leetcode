package hashtable.leetcode_49;

import java.util.*;

//Given an array of strings, group anagrams together.
//
//        Example:
//
//        Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//        Output:
//        [
//        ["ate","eat","tea"],
//        ["nat","tan"],
//        ["bat"]
//        ]
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String,List<String>> res = new HashMap<>();
        for(int i = 0;i<strs.length;i++)
        {
            char[] chars = strs[i].toCharArray();//каждую строку сортируем
            Arrays.sort(chars);
            String s = new String(chars);//делаем новый ключ
            if(!res.containsKey(s)) res.put(s,new ArrayList<String>());//если нет такого ключа то создаем для него лист
            res.get(s).add(strs[i]);
        }
        return new ArrayList<>(res.values());//все листы тащим
    }
}
