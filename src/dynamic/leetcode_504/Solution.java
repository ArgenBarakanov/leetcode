package dynamic.leetcode_504;
//The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
//
//        F(0) = 0,   F(1) = 1
//        F(N) = F(N - 1) + F(N - 2), for N > 1.
public class Solution {
    public int fib(int N) {
        if(N<1)return 0;
        int[] fib = new int[N+1];
        fib[1]=1;

        for(int i=2;i<=N;i++){
            fib[i]=fib[i-1]+fib[i-2];
        }
        return fib[N];
    }
}
