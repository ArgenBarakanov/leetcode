package dynamic.leetcode_282;

import java.util.ArrayList;
import java.util.List;

//Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
//
//        Example 1:
//
//        Input: num = "123", target = 6
//        Output: ["1+2+3", "1*2*3"]
//        Example 2:
//
//        Input: num = "232", target = 8
//        Output: ["2*3+2", "2+3*2"]
//        Example 3:
//
//        Input: num = "105", target = 5
//        Output: ["1*0+5","10-5"]
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);//запускаем наш дфс
        return rst;
    }
    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
        if(pos == num.length()){//если в конце строки то сравниваем результат с эталоном
            if(target == eval)
                rst.add(path);
            return;
        }

        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;// если начинается с 0 то невозможно дать ответ
            long cur = Long.parseLong(num.substring(pos, i + 1));//вычленяем каждое число
            if(pos == 0){
                helper(rst, path + cur, num, target, i + 1, cur, cur);// самое начало
            }
            else{
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);

                helper(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);//последний аргумент для умножения

                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
            }
        }

    }
}
