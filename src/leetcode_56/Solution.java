package leetcode_56;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Given a collection of intervals, merge all overlapping intervals.
//
//        Example 1:
//
//        Input: [[1,3],[2,6],[8,10],[15,18]]
//        Output: [[1,6],[8,10],[15,18]]
//        Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {

        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        };
        Collections.sort(intervals, comparator);
        List<Interval> res = new ArrayList<>();
        if (intervals.size() < 1)
            return res;
        int start = intervals.get(0).start;//начало интервала
        int end = intervals.get(0).end;//конец интервала
        for (Interval i : intervals) {
            if (i.start <= end)
                end = Math.max(end, i.end);//если нчало интервала меньше чем текущий интервал то включаем его в интервал
            else {
                res.add(new Interval(start, end));//иначе записываем текущий интервал в список и обновляем значения старта и конца
                start = i.start;
                end = i.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
