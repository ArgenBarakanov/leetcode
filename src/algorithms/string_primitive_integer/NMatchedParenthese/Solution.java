package algorithms.string_primitive_integer.NMatchedParenthese;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //leetcode_22
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res,"",0,0,n);
        return res;

    }
    public void backtrack(List<String> res, String str, int open, int close, int max){
        if(str.length()==2*max)//если длина строки равна лимиту то добавим строку в результат
        {
            res.add(str);
            return;
        }
        if(open<max)//если открывающих все еще меньше чем максимальное количество то добавим его в строку
            backtrack(res,str+"(",open+1,close,max);
        if(close<open)//если закрывающих меньше открывающих то добавим и его
            backtrack(res,str+")",open,close+1,max);
    }

    //лцчше нарисовать дерево вызова функций для 3 скобок и все будет понятно
}
