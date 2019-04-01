package leetcode_151;

import java.util.ArrayList;
import java.util.List;

//Given an input string, reverse the string word by word.
//
//
//
//        Example 1:
//
//        Input: "the sky is blue"
//        Output: "blue is sky the"
public class Solution {
    public String reverseWords(String s) {
        int i =0;
        List<String> list = new ArrayList<>();
        while(i<s.length()){
            if(s.charAt(i)==' ')i++;//скипаем пробелы
            else{
                StringBuilder stringBuilder = new StringBuilder();
                while(i<s.length()&&s.charAt(i)!=' '){//пока встречаем буквы записываем посимвольно в стрингбилдер
                    stringBuilder.append(s.charAt(i));
                    i++;
                }
                list.add(0,stringBuilder.toString());//пишем в начало списка
            }
        }
        StringBuilder res = new StringBuilder();
        for(String str:list){
            res.append(str);
            res.append(" ");//склеиваем в обратном порядке
        }
        return res.toString().trim();
    }
}
