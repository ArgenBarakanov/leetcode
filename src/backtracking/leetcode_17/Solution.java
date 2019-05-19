package backtracking.leetcode_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static Map<Character,String> map = new HashMap<>();
    static  {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }
    public List<String> letterCombinations(String digits) {
        if(digits.equals(""))
            return new ArrayList<>();
        int index = 0;
        List<String> res = combs(index,digits);
        return res;
    }
    public List<String> combs(int index,String digits)
    {
        if(index>digits.length()-1)
        {
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        List<String> current = new ArrayList<>();//текущий набор буквы
        List<String> prev = combs(index+1,digits);
        String letters = map.get(digits.charAt(index));
        for(int i=0;i<letters.length();i++)
        {
            for(int j=0;j<prev.size();j++)
            {
                current.add(letters.charAt(i)+prev.get(j));//добавляем каждую букву кнопки к каждой сгененированной строке на предыдущем вызове функции
            }
        }
        return current;
    }
}
