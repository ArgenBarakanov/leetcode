package hashtable.leetcode_159;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) return 0;
        if (s.length() < 3) return s.length();

        int l = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>(); // <char, counter>
        for (int r=0; r<s.length(); r++) {//двигаем правый указатель до тех пор пока не наткнемся на то что в мап будет уже 3 разных символа. в процессе обновляем максимум
            char rc = s.charAt(r);
            int rCharCnt = map.getOrDefault(rc, 0);
            map.put(rc, rCharCnt+1);

            if (isValid(map)) {
                maxLen = Math.max(maxLen, r-l+1);
            }

            while (!isValid(map)) {//пока карта невалидна мы удаляем буквы под плевым указателем
                char lc = s.charAt(l);
                int lCharCnt = map.get(lc);
                if (lCharCnt == 1) {
                    map.remove(lc);
                } else {
                    map.put(lc, lCharCnt-1);
                }
                l++;
            }
        }
        return maxLen;
    }

    private boolean isValid(Map<Character, Integer> map) {
        return map.size() < 3;
    }
}
