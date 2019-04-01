package leetcode_150;

import java.util.Stack;

//Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//        Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
//        Note:
//
//        Division between two integers should truncate toward zero.
//        The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
//        Example 1:
//
//        Input: ["2", "1", "+", "3", "*"]
//        Output: 9
//        Explanation: ((2 + 1) * 3) = 9
public class Solution {
    public int evalRPN(String[] tokens) {//если делим то берем предпоследнее и делим на последнее. при умножение перемножаем два предыдущих.
        // при сложениее складываем два предпоследних при вычитании из предпоследнего вычтем последнее
        Stack<Integer> stack = new Stack<>();
        int a, b;
        for(String s:tokens){
            if(s.equals("+")){
                a=stack.pop();
                b=stack.pop();
                stack.add(a+b);
            }else if(s.equals("-")){
                b = stack.pop();
                a=stack.pop();
                stack.add(a-b);
            }else if(s.equals("*"))
            {
                stack.add(stack.pop()*stack.pop());
            }else if(s.equals("/")){
                b=stack.pop();
                a=stack.pop();
                stack.add(a/b);
            }
            else{
                stack.add(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
