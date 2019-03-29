package leetcode_28;

//Implement strStr().
//
//        Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//        Example 1:
//
//        Input: haystack = "hello", needle = "ll"
//        Output: 2
public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.equals("")&&!needle.equals(""))//всякие корнер кейсы
            return -1;
        if(haystack.equals("")&&needle.equals(""))
            return 0;
        if(!haystack.equals("")&&needle.equals(""))
            return 0;
        if(!haystack.contains(needle))
        {
            return -1;
        }
        else
        {
            char[] word = haystack.toCharArray();//слово превращаем в массив символов
            char target = needle.charAt(0);
            int start = -1;
            for(int i = 0; i<word.length;i++)
            {
                if(word[i]==target)//если совпадает первый  то ищем подстроку
                {
                    if(i+needle.length()<=haystack.length())//если подстрока меньше чем длина и встроенный метод
                    {
                        if(haystack.substring(i,i+needle.length()).equals(needle))
                        {
                            start=i;
                            break;
                        }
                    }
                }
            }
            return start;
        }
    }
}
