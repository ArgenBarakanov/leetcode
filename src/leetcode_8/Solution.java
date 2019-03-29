package leetcode_8;

import java.util.HashSet;
import java.util.Set;

//8. String to Integer (atoi)
//        Medium
//
//        760
//
//        4936
//
//        Favorite
//
//        Share
//        Implement atoi which converts a string to an integer.
//
//        The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
//
//        The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
//
//        If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
//
//        If no valid conversion could be performed, a zero value is returned.
//
//        Note:
//
//        Only the space character ' ' is considered as whitespace character.
//        Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
//        Example 1:
//
//        Input: "42"
//        Output: 42
public class Solution {
    public int myAtoi(String str) {
        if(str.equals(""))
            return 0;
        Set<Character> set = new HashSet<>();
        set.add('0');
        set.add('1');
        set.add('2');
        set.add('3');
        set.add('4');
        set.add('5');
        set.add('6');
        set.add('7');
        set.add('8');
        set.add('9');
        String res = str.trim();
        if(res.equals(""))
            return 0;
        int sign = 1;
        int index = 0;
        long result = 0;
        if(res.charAt(index)=='-'||res.charAt(index)=='+')//помечаем какой знак  у нас
        {
            sign = res.charAt(index)=='-'?-1:1;
            index++;
        }

        while(index<res.length())
        {
            char c = res.charAt(index);
            if(!set.contains(c))//если не цифра то прерываемся
                break;
            result = result*10+(c-'0');//все стандартно. считали прибавили к умноженному на 10 результату
            if(result>Integer.MAX_VALUE&&sign==1) {//overflow

                return Integer.MAX_VALUE;
            }
            else if(result>Integer.MAX_VALUE&&sign==-1) {

                return Integer.MIN_VALUE;
            }


            index++;
        }
        return (int)result*sign;
    }
}