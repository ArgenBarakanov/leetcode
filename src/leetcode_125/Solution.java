package leetcode_125;
//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//        Note: For the purpose of this problem, we define empty string as valid palindrome.
//
//        Example 1:
//
//        Input: "A man, a plan, a canal: Panama"
//        Output: true
public class Solution {
    public boolean isPalindrome(String s) {
        if(s.equals(""))
            return true;
        String word = s.toLowerCase();
        int start = 0,end = word.length()-1;
        while(start<end){//с двух концов проверяем не является ли символ пробелом
            if(!Character.isLetterOrDigit(word.charAt(start))){
                start++;
                continue;}
            if(!Character.isLetterOrDigit(word.charAt(end))){
                end--;
                continue;
            }
            if(word.charAt(start)!=word.charAt(end))
                return false;//если символы неравны то вернем ложь
            start++;
            end--;
        }
        return true;//если прошел до конца цикл то вернем истину
    }
}
