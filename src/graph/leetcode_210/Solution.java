package graph.leetcode_210;

import java.util.*;

//There are a total of n courses you have to take, labeled from 0 to n-1.
//
//        Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//        Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
//
//        There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
//
//        Example 1:
//
//        Input: 2, [[1,0]]
//        Output: [0,1]
//        Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
//        course 0. So the correct course order is [0,1] .
//        Example 2:
//
//        Input: 4, [[1,0],[2,0],[3,1],[3,2]]
//        Output: [0,1,2,3] or [0,2,1,3]
//        Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
//        courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
//        So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .   Topological sort
public class Solution {
    Stack<Integer> stack = new Stack<>();//заносим поочередно все вершины у которых уже не осталось непосещенных соседей
    HashSet<Integer> set = new HashSet<>();//маркер для того чтобы знать посещали ли мы эту вершину и его детей.


    public  int[] findOrder(int numCourses, int[][] prerequisites){
        int[] sorted = new int[numCourses];
        boolean[] visited = new boolean[numCourses];// для того чтобы задетектить цикл в графе
        List<Integer>[] adj = new List[numCourses];
        for(int i = 0; i < numCourses; i++)
            adj[i] = new ArrayList<Integer>();// составляем список смежности
        for(int i = 0; i < prerequisites.length; i++)
        {
            int curCourse = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            adj[preCourse].add(curCourse);// заполняем список смежности
        }
        for(int course = 0;course<numCourses;course++){
            if(set.contains(course))// если уже был включен то мы уже посетили все его смежные вершины и не надо посещать еще раз
                continue;
            if(!dfs(visited,course,adj))
                return new int[0];//нашли цикл то вернем пустой массив
        }
        for(int i=0;i<numCourses;i++){
            sorted[i] = stack.pop();//в обратном порядке вытаскиваем вершины
        }
        return sorted;
    }

    public boolean dfs(boolean[] visited,int course,List<Integer>[] adj){
        if(visited[course])
            return false;//если ранее уже посещали то это цикл
        visited[course]=true;//посещаем как посещенную и для его списка смежности запускаем рекурсивно
        for(int i :adj[course]){
            if(set.contains(i))
                continue;
            if(!dfs(visited,i,adj)){
                return false;
            }
        }
        if(!set.contains(course)){stack.push(course);// если в сете его нет то пихаем в стэк так как у него не осталось непосещенных смежных
            set.add(course);// добавили в сет
        }
        visited[course]=false;// обратно помечаем
        return true;
    }
}
