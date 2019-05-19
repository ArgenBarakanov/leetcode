package math.leetcode_168;
//Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//
//        For example:
//
//        1 -> A
//        2 -> B
//        3 -> C
//        ...
//        26 -> Z
//        27 -> AA
//        28 -> AB
//        ...
public class Solution {
    StringBuilder builder = new StringBuilder();
    public String convertToTitle(int n) {
        while(n>0){
            n--;
            builder.append((char) ('A'+n%26));//начинаем с конца .остаток от деления на 26 прикручиваем в строку и делим на 26
            n = n/26;
        }
        return builder.reverse().toString();
    }
}
