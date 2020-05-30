package repeat.bfs.leetcode_301;

import java.util.*;

public class Solution {
    public static List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        if (s == null) return list;

        Set<String> visited = new HashSet<>();
        visited.add(s);

        Queue<String> queue = new LinkedList<>();
        queue.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if(isValid(current)) {
                list.add(current);
                found = true;
            }

            // to prevent go to the next level - no sense to generate candidates smaller then current
            if (found) continue;

            for(int i=0; i<current.length(); i++) {
                if (current.charAt(i) != '(' && current.charAt(i) != ')') continue;
                String candidate = current.substring(0, i) + current.substring(i+1);
                if (!visited.contains(candidate)) {
                    visited.add(candidate);
                    queue.add(candidate);
                }
            }

        }
        return list;
    }
    private static boolean isValid(String s) {
        int counter = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') counter++;
            if (c == ')') {
                counter--;
                if (counter < 0) return false;
            }
        }
        return counter == 0;
    }
}
