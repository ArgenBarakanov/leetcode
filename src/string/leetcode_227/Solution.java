package string.leetcode_227;

import java.util.Stack;

//Implement a basic calculator to evaluate a simple expression string.
//
//        The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
//
//        Example 1:
//
//        Input: "3+2*2"
//        Output: 7
//        Example 2:
//
//        Input: " 3/2 "
//        Output: 1
//        Example 3:
//
//        Input: " 3+5 / 2 "
//        Output: 5
public class Solution {
    public int calculate(String s) {
        int len;
        if(s==null || (len = s.length())==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for(int i =0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                num = 10*num+s.charAt(i)-'0';//если это число то заносим его в число
            }
            if(!Character.isDigit(s.charAt(i))&&s.charAt(i)!=' '||i==len-1){
                if(sign=='+')//если плюс то заносим число если минус то со знаком минус если умножение и деление то берем из стека умножаем или делим и вновь пихаем
                {
                    stack.push(num);
                }
                if(sign=='-')
                {
                    stack.push(-num);
                }
                if(sign=='/')
                {
                    stack.push(stack.pop()/num);
                }
                if(sign=='*')
                {
                    stack.push(stack.pop()*num);
                }
                sign = s.charAt(i);
                num=0;
            }
        }
        int res = 0;
        for(int i:stack)
        {
            res+=i;//в конце все складываем
        }
        return res;
    }
}
