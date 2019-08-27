package math.leetcode_204;

import java.util.Arrays;
//Count the number of prime numbers less than a non-negative number, n.
//
//        Example:
//
//        Input: 10
//        Output: 4
//        Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
public class Solution {
    public int countPrimes(int n) {
        boolean[] Prime = new boolean[n];
        Arrays.fill(Prime,true);
        int res = 0;
        for(int i = 2;i<n;i++)// начинаем с 2
        {
            if(Prime[i])
                res++;//если число простое то увеличиваем счетчик
            for(int j=2;i*j<n;j++)
            {
                Prime[i*j]=false;// и все числа где это простое число является делителем мы делаем составным
            }
        }
        return res;
    }
}
