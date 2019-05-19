package string.leetcode_58;

//Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
//
//        If the last word does not exist, return 0.
//
//        Note: A word is defined as a character sequence consists of non-space characters only.
//
//        Example:
//
//        Input: "Hello World"
//        Output: 5
public class Solution {
    public int lengthOfLastWord(String s) {
        if(s.equals(""))
            return 0;
        int i = s.length()-1,j=0;
        while(i>=0)
        {
            if(s.charAt(i)==' ')//скипаем пока не закончатся пробелы
                i--;
            else
                break;
        }
        if(i<0) {
            return 0;//если индекс меньше нуля то вся строка это пробелы
        }
        while(i>=0)
        {
            j++;
            i--;
            if(i==-1||s.charAt(i)==' ')//скипаем каждый символ инкрементируя счетчик пока не станет -1 или не встретим пробел
                break;
        }
        return j;
    }
}
