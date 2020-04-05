package repeat.string.leetcode_5;

public class Solution {
    int low = 0;
    int maxLen = 0;
    public String longestPalindrome(String s) {
      for(int i = 0; i < s.length(); i++){
          extend(i,i + 1, s);
          extend(i, i, s);
      }
      return s.substring(low, low + maxLen);
    }

    public void extend(int j, int k, String s){
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
            j--;
            k++;
        }
        if(maxLen < k - j -1){
            low = j + 1;
            maxLen = k - j - 1;
        }
    }
}
