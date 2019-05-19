package hashtable.leetcode_3;

import java.util.HashSet;
import java.util.Set;

//Given a string, find the length of the longest substring without repeating characters.
//
//        Example 1:
//
//        Input: "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set =  new HashSet<>();//кладем все буквы и если повторяется удаляем
        int ans = 0,i = 0,j = 0;
        while(i<s.length()&&j<s.length())
        {
            if(!set.contains(s.charAt(j)))//если не содержит буквы добавляем
            {
                set.add(s.charAt(j++));//добавляем и двигаем правый указатель
                ans = ans>j-i?ans:j-i;//обновляем максимальную длину
            }
            else
            {
                set.remove(s.charAt(i++));//удаляем букву с индексом левого указателя
            }
        }
        return ans;
    }
}
