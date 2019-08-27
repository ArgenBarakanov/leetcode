package hashtable.leetcode_205;

import java.util.HashMap;
import java.util.Map;

//Given two strings s and t, determine if they are isomorphic.
//
//        Two strings are isomorphic if the characters in s can be replaced to get t.
//
//        All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.equals("")&&t.equals(""))return true;
        if(s.length()!=t.length())return false;
        Map<Character,Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){//если нет такой буквы в мапе из слова s

                if(!map.containsValue(t.charAt(i))){//если нет буквы из слова t
                    System.out.println(s.charAt(i)+" - "+t.charAt(i));
                    map.put(s.charAt(i),t.charAt(i));}//сопоставляем их
            }
        }
        for(int i=0;i<t.length();i++){
            Character c = t.charAt(i);//и посто сопоставляем их
            if(!c.equals(map.get(s.charAt(i))))return false;
        }
        return true;
    }
}
