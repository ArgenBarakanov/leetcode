package graph.leetcode_207;

import java.util.ArrayList;
import java.util.List;

//There are a total of n courses you have to take, labeled from 0 to n-1.
//
//        Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//        Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean[] visited = new boolean[numCourses];
        List<Integer>[] adj = new List[numCourses];
        for(int i = 0; i < numCourses; i++)
            adj[i] = new ArrayList<Integer>();
        for(int i = 0; i < prerequisites.length; i++)
        {
            int curCourse = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            adj[preCourse].add(curCourse);
        }
        for(int i = 0; i < numCourses; i++)
        {
            if(!dfs(adj, visited, i))
                return false;
        }
        return true;
    }

    private boolean dfs(List<Integer>[] adj, boolean[] visited, int course){

        if(visited[course])         // have circle
            return false;
        visited[course] = true;
        for (int i = 0; i < adj[course].size(); i++)
        {
            if(!dfs(adj, visited, adj[course].get(i)))
                return false;
            adj[course].remove(i);  // delete edge ускоряет работу. так как не надо проходить по этому ребру в нем нет цикла
        }
        visited[course] = false;
        return true;
    }
}
