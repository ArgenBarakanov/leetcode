package array.leetcode_66;

//Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
//
//        The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
//
//        You may assume the integer does not contain any leading zero, except the number 0 itself.
//
//        Example 1:
//
//        Input: [1,2,3]
//        Output: [1,2,4]
//        Explanation: The array represents the integer 123.
public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for(int i = digits.length-1;i>=0;i--)
        {
            digits[i]=digits[i]+carry;
            if(i==digits.length-1)
                digits[i]=digits[i]+1;//добавляем только к крайнему левому числу в массиве
            carry = digits[i]/10;
            digits[i]=digits[i]%10;//обновляем перенос и число
        }
        int[] res2 = new int[digits.length+1];
        if(carry>0)//если перенос не равен нулю то добавим его в конце справа
        {
            res2[0]=carry;
            for(int i = 1;i<digits.length;i++)
            {
                res2[i]=digits[i];
            }
            return res2;
        }
        return digits;
    }

    public int[] plusOne2(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] res = new int[1 + digits.length];
        res[0] = 1;
        return res;
    }
}