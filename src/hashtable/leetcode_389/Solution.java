package hashtable.leetcode_389;

public class Solution {
    static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y',
            'z'};
    public char findTheDifference(String s, String t) {
        int[] mas = new int[26];
        int id = 0;
        for(int i=0;i<s.length();i++){
            mas[s.charAt(i)-'a']++;//все как в предыдущем случае
        }
        for(int i=0;i<t.length();i++){
            mas[t.charAt(i)-'a']--;
            if(mas[t.charAt(i)-'a']<0){id = t.charAt(i)-'a';
                break;
            }
        }

        return alphabet[id];
    }
}
