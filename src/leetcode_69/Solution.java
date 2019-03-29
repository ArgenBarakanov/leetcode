package leetcode_69;

//Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
//
//        Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
//
//        Example 1:
//
//        Input: 4
//        Output: 2
public class Solution {
    public int mySqrt(int x) {//бинарный поиск. ничего сложного в этом нет
        if(x<1)return 0;
        int ans =0;
        int low = 1, high = x;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(mid<=x/mid){
                low = mid+1;
                ans = mid;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
}
