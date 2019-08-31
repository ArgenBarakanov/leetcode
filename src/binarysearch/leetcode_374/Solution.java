package binarysearch.leetcode_374;
//We are playing the Guess Game. The game is as follows:
//
//        I pick a number from 1 to n. You have to guess which number I picked.
//
//        Every time you guess wrong, I'll tell you whether the number is higher or lower.
//
//        You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
//
//        -1 : My number is lower
//        1 : My number is higher
//        0 : Congrats! You got it!
public class Solution {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0)
                return mid;
            else if (res < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
    public int guess(int mid){
        return -1;
    }
}
