package bitmanipulation.leetcode_190;
//развернуть биты
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        StringBuffer sb = new StringBuffer();
        String s = Integer.toBinaryString(n);
        for(int i = 0; i < 32-s.length(); i++)
            sb.append('0');
        s = sb.toString() + s;
        char[]  c = s.toCharArray();
        int r = 0;
        for(int i = 0; i < 32; i++){
            if(c[i] == '1')
                r += (1 << i);
        }
        return r;
    }
}
