package math.leetcode_50;

//Implement pow(x, n), which calculates x raised to the power n (xn).
public class Solution {
    public double myPow(double x, int n) {
        long n2 = n;
        if(n2<0)
            return 1/myPow2(x,-n2);
        else
            return myPow2(x,n2);
    }
    public double myPow2(double x, long n) {
        if(n==0)
            return 1;
        if(n%2==0)
        {

            double temp = myPow2(x,n/2);//получить предыдущее и умножить на самого себя если степень четная
            return temp*temp;
        }
        else
        {

            return x*myPow2(x,n-1);//если нечетная то х умножаем на себя в четной степени
        }
    }
}
