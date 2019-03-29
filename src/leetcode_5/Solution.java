package leetcode_5;

//Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
//        Example 1:
//
//        Input: "babad"
//        Output: "bab"
//        Note: "aba" is also a valid answer.
//        Example 2:
//
//        Input: "cbbd"
//        Output: "bb"
class Solution {
    int low,maxlen;// индексы начала и конца
    public String longestPalindrome(String s) {
        int len = s.length();

        if (len < 2)
            return s;
        for(int i=0;i<s.length()-1;i++)
        {
            extend(s,i,i);//ищем палиндром с нечетным количеством и четным
            extend(s,i,i+1);
        }
        return s.substring(low,low+maxlen);
    }

    public void extend(String s,int j,int k)
    {
        while(j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k))
        {
            j--;//левый  индекс идет влево а првый вправо
            k++;
        }
        if(maxlen<k-j-1)
        {
            low = j+1;//обновляемм длину  каждый раз как находим палиндром большей длины
            maxlen = k-j-1;
        }
    }
}
