package leetcode_140;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static List<String> wordBreak(String s,List<String> wordDict){
        return wordBreak2(s,wordDict,new HashMap<>());
    }
    public static  List<String> wordBreak2(String s, List<String> wordDict,HashMap<String,List<String>> map) {
        if(map.containsKey(s))
            return map.get(s);//если для данного слова уже есть то вернем строки которые им нагенерированы


        List<String> result = new ArrayList<>();
        if(s.length()==0)
        {
            result.add("");
            return result;
        }
        for(String str : wordDict)
        {
            if(s.startsWith(str))//если слово начинается на слово в словаре то рекурсивно запускаем
            {
                List<String> sublist = wordBreak2(s.substring(str.length()),wordDict,map);
                for(String toAdd : sublist)
                {
                    result.add(0,(str+" "+toAdd).trim());// к результату добавляем в начале слово
                }
            }
        }
        map.put(s,result);
        return result;
    }
}
