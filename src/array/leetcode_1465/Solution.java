package array.leetcode_1465;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {

    static int mod = 1000000007;

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] hor = {3};
        int[] ver = {3};
        System.out.println(solution.maxArea(5,4, hor, ver));
    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        List<Integer> horizontCut = getList(horizontalCuts, h);
        List<Integer> verticalCut = getList(verticalCuts, w);
        int max_h = getMaxDiff(horizontCut);
        int max_v = getMaxDiff(verticalCut);
        return (int)((long)max_h * max_v % 1000000007);
    }

    public List<Integer> getList(int[] cuts, int size) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        Arrays.stream(cuts).forEach(list::add);
        list.add(size);
        return list;
    }

    public int getMaxDiff(List<Integer> list) {
        int maxDiff = 0;
        int prevCut = 0;
        for(Integer i : list) {
            int cut = i - prevCut;
            maxDiff = Math.max(cut, maxDiff);
            prevCut = i;
        }
        return maxDiff;
    }
}
