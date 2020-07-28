package hashtable.leetcode_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
                ans = Math.max(ans, j - i);//обновляем максимальную длину
            }
            else
            {
                set.remove(s.charAt(i++));//удаляем букву с индексом левого указателя
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abba";
       Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring2(s));
    }

    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0, j = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i)) + 1);// либо смещаем левый край в одну букву направо либо ничего не делаем
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i -j +1);
        }
        return max;
    }
}
