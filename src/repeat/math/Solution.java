package repeat.math;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isPalindrome(int x) {
      if(x < 0) return false;
      List<Integer> list = new ArrayList<>();
      while (x > 0){
          list.add(x%10);
          x= x/10;
      }
      int mid = list.size()/2;
      for(int i =0; i<= mid ; i++){
          if(list.get(i) != list.get(list.size() - i -1))return false;
      }
      return true;
    }
}
