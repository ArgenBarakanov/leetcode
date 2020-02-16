package array.leetcode_57;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//
//        You may assume that the intervals were initially sorted according to their start times.
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultList = new ArrayList<>();

        for(int[] interval : intervals) {
            if(newInterval[0] > interval[1]) {
                resultList.add(interval);
            }
            else if(newInterval[1] < interval[0]) {
                resultList.add(newInterval);
                newInterval = interval;
            }
            else {
                int[] merged = new int[] {Math.min(newInterval[0], interval[0]), Math.max(newInterval[1], interval[1])};
                newInterval = merged;
            }
        }
        resultList.add(newInterval);

        int[][] result = new int[resultList.size()][2];
        for(int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
