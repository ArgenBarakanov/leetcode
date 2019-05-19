package string.leetcode_14;

//Write a function to find the longest common prefix string amongst an array of strings.
//
//        If there is no common prefix, return an empty string "".
//
//        Example 1:
//
//        Input: ["flower","flow","flight"]
//        Output: "fl"
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0||strs==null)
            return "";
        for(int i =0 ;i<strs[0].length();i++)//для кажой буквы первого слова
        {
            char c = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++)
            {
                if(i==strs[j].length()||c!=strs[j].charAt(i))//сравниваем буквы по позициям каждого слова и если слово закончилось или буквы не совпдают то просто заканчиваем работу метода

                    return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }
}
