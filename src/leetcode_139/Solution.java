package leetcode_139;

import java.util.List;

//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//        Note:
//
//        The same word in the dictionary may be reused multiple times in the segmentation.
//        You may assume the dictionary does not contain duplicate words.
//        Example 1:
//
//        Input: s = "leetcode", wordDict = ["leet", "code"]
//        Output: true
//        Explanation: Return true because "leetcode" can be segmented as "leet code".
class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        boolean[] f = new boolean[s.length()+1];
        f[0]=true;//пустая строка совпадает
        for(int i = 1; i <= s.length(); i++){//для каждого смивола
            for(String str: dict){//перебираем весь словарь
                if(str.length()<=i)//если для этого слова длина его меньше позиции
                {
                    if(f[i-str.length()])//предыдущий тоже равен истине
                    {
                        if(s.substring(i-str.length(),i).equals(str))//если совпали то помечаем и прерываем словарь
                        {
                            f[i]=true;
                            break;
                        }
                    }
                }
            }
        }
        return f[s.length()];
    }
}
