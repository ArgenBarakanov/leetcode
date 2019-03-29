package leetcode_9;

import java.util.ArrayList;
import java.util.List;

//Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
//
//        Example 1:
//
//        Input: 121
//        Output: true
//        Example 2:
//
//        Input: -121
//        Output: false
//        Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
public class Solution {
    public boolean isPalindrome(int x) {
        if(x==0)
        {
            return true;
        }
        if(x<0)
            return false;
        List<Integer> list = new ArrayList<>();
        while(x>0)
        {
            list.add(x%10);// добавляем цифры поочередно
            x=x/10;
        }

        int mid = list.size()/2;//находим середину списка
        for(int i=0;i<=mid;i++)
        {
            if(list.get(i)!=list.get(list.size()-i-1))//сравниваем слева и справа
                return false;
        }
        return true;
    }
}
