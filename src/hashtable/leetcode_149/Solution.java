package hashtable.leetcode_149;

import java.util.HashMap;

 class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }
public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null) return 0;
        int n = points.length, result = 0;
        if(n <= 2) return n;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.clear();
            int overlap = 0, max = 0;
            for(int j = i + 1 ; j < n ; j++){
                int x=points[j].x-points[i].x;
                int y=points[j].y-points[i].y;
                if (x==0 && y==0){
                    overlap++;
                    continue;
                }
                int gcd = generateGCD(x,y); // gcd will never be zero.
                x/=gcd;
                y/=gcd;
                String key = x + ":" + y;
                if (map.containsKey(key))
                    map.put(key,map.get(key) + 1);
                else
                    map.put(key, 1);
                max = Math.max(max, map.get(key));
            }
            result = Math.max(result, max+overlap+1);
        }
        return result;
    }

    private int generateGCD(int a,int b){

        if (b==0) return a;
        else return generateGCD(b,a%b);

    }
}
