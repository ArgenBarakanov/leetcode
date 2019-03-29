package leetcode_20;

import java.util.Stack;

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//        An input string is valid if:
//
//        Open brackets must be closed by the same type of brackets.
//        Open brackets must be closed in the correct order.
//        Note that an empty string is also considered valid.
//
//        Example 1:
//
//        Input: "()"
//        Output: true
//        Example 2:
//
//        Input: "()[]{}"
//        Output: true
//        Example 3:
//
//        Input: "(]"
//        Output: false
public class Solution {
    public boolean isValid(String s) {//по моему тут все очевидно. пихаем в стэк скобки закрвающиеся
        //если скобка открывабщаяся. если стэк пуст(не хватило открывающихся скобок или если при извлечении скобки разные)
        Stack<Character> stack = new Stack<>();
        boolean isvalid = true;
        for(Character c : s.toCharArray())
        {
            if(c=='[')
                stack.push(']');
            else if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else
            {
                if(stack.isEmpty())
                    isvalid=false;
                else
                {
                    isvalid = c==stack.pop();
                }
                if(!isvalid)
                    break;
            }
        }
        if(!stack.isEmpty())
            isvalid=false;
        return isvalid;
    }
}
