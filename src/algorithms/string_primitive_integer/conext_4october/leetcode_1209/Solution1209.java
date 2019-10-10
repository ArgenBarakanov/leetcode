package algorithms.string_primitive_integer.conext_4october.leetcode_1209;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution1209 {
    public static String removeDuplicates(String s, int k) {
        Stack<Integer> neighboorCount = new Stack<>();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while(i<s.length()){
            if(!stack.isEmpty()&&stack.peek()==s.charAt(i)){
                stack.push(s.charAt(i));
                neighboorCount.push(neighboorCount.peek()+1);
            }else {
                stack.push(s.charAt(i));
                neighboorCount.push(1);
            }
            if(neighboorCount.peek()==k){
                for(int j = 0;j<k;j++){
                    stack.pop();
                    neighboorCount.pop();
                }
            }
            i++;
        }
        StringBuilder str = new StringBuilder();
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
    public static  void main (String[] args){

        System.out.println(removeDuplicates("pbbcggttciiippooaais",2));
    }
}
