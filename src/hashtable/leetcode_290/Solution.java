package hashtable.leetcode_290;

import java.util.HashMap;
//Given a pattern and a string str, find if str follows the same pattern.
//
//        Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
//
//        Example 1:
//
//        Input: pattern = "abba", str = "dog cat cat dog"
//        Output: true
//        Example 2:
//
//        Input:pattern = "abba", str = "dog cat cat fish"
//        Output: false
//        Example 3:
//
//        Input: pattern = "aaaa", str = "dog cat cat dog"
//        Output: false
//        Example 4:
//
//        Input: pattern = "abba", str = "dog dog dog dog"
//        Output: false
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] arr= str.split(" ");
        HashMap<Character, String> map = new HashMap<Character, String>();
        if(arr.length!= pattern.length())
            return false;
        for(int i=0; i<arr.length; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){//если уже есть такая буква то она может быть занята другим словом
                if(!map.get(c).equals(arr[i]))
                    return false;
            }else{
                if(map.containsValue(arr[i]))//иначе буквы может и не быть но слово которое мы привязываем к букве уже может быть привязано к другой букве
                    return false;
                map.put(c, arr[i]);//иначе кладем в мау
            }
        }
        return true;
    }
}
