package string.leetcode_22;

import java.util.ArrayList;
import java.util.List;

//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//        For example, given n = 3, a solution set is:
//
//        [
//        "((()))",
//        "(()())",
//        "(())()",
//        "()(())",
//        "()()()"
//        ]
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res,"",0,0,n);//передаем результирующий лист строку и кол-во открытых и закрытых скобок и максимальное количество кобок
        return res;
    }
    public void backtrack(List<String> res,String str,int open,int close,int max){
        if(str.length()==2*max)//если длина строки уже достигла максимума то записываем в лист и возвращаемся
        {
            res.add(str);
            return;
        }
        if(open<max)//если открытых меньше чем максимальное количество то добавляем
            backtrack(res,str+"(",open+1,close,max);
        if(close<open)//если закрытых меньше открытых то можно добавить закрытую
            backtrack(res,str+")",open,close+1,max);
    }
}
