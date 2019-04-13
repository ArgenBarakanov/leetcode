package leetcode_76;

import java.util.HashMap;
import java.util.Map;

//Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
//        Example:
//
//        Input: S = "ADOBECODEBANC", T = "ABC"
//        Output: "BANC"
//        Note:
//
//        If there is no such window in S that covers all characters in T, return the empty string "".
//        If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
public class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0||t.length()==0)
            return "";
        Map<Character,Integer> dictT = new HashMap<>();
        Map<Character,Integer> currentWin = new HashMap<>();//текущий словарь с буквами
        for(int i=0;i<t.length();i++)
        {
            int count = dictT.getOrDefault(t.charAt(i),0);//буквы и их число в нужном нам количестве
            dictT.put(t.charAt(i),count+1);
        }

        int required = dictT.size();//uniq characters//уникальных букв
        int[] res = {-1,0,0};
        int r =0, l = 0;//два индекса
        int formed = 0;//нашли все буквы?
        while(r<s.length())
        {
            char c = s.charAt(r);
            int count = currentWin.getOrDefault(c,0);
            currentWin.put(c,count+1);
            if(dictT.containsKey(c)&&currentWin.get(c).intValue()==dictT.get(c).intValue())
                formed++;//если формед равен реувайред то в нынешнем словаре уже содержится то что нам нужно

            while (l<=r&&formed==required)//пока все ок уменьшаем наш отрезок строки
            {
                c = s.charAt(l);
                if(res[0]==-1||(r-l+1<res[0]))
                {
                    res[0]=r-l+1;
                    res[1]=l;
                    res[2]=r;
                }

                currentWin.put(c,currentWin.get(c)-1);
                if(dictT.containsKey(c)&&currentWin.get(c).intValue()<dictT.get(c).intValue())
                    formed--;

                l++;
            }
            r++;//двигаем правый ползунок
        }

        return res[0] == -1 ? "" : s.substring(res[1], res[2] + 1);
    }
}
