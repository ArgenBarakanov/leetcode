package leetcode_166;

import java.util.HashMap;

//Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
//
//        If the fractional part is repeating, enclose the repeating part in parentheses.
//
//        Example 1:
//
//        Input: numerator = 1, denominator = 2
//        Output: "0.5"
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "";
        StringBuilder str = new StringBuilder();
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
            str.append('-');
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        long n = num/den;// деление нацело
        long reminder = num % den;//остаток
        str.append(n);
        if (reminder == 0) return str.toString();
        else str.append('.');
        while(!map.containsKey(reminder)) {//пока не повторится остаток
            map.put(reminder,str.length());
            n = reminder*10/den;
            reminder = reminder*10%den;
            if (reminder != 0 || reminder == 0 && !map.containsKey(reminder)) {//если не равно 0 или нет в карте то добавим
                str.append(n);
            }
        }
        if (reminder != 0) {
            str.insert(map.get(reminder),"(");//добавим скобки
            str.append(')');
        }
        return str.toString();
    }
}
