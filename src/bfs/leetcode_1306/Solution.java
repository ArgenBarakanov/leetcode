package bfs.leetcode_1306;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution {
    public boolean canReach(int[] arr, int start) {
        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()){
            int current = queue.poll();
            if(arr[current] == 0) return true;
            int forward = current + arr[current];
            int back = current - arr[current];
            if(forward < arr.length){
                if(!visited.contains(forward)){
                queue.add(forward);
                visited.add(forward);
                }
            }
            if(back >= 0){
                if(!visited.contains(back)){
                queue.add(back);
                visited.add(back);
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] arr = {3,0,2,1,2};
        System.out.println(solution.canReach(arr,2));
    }

}
