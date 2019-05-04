package leetcode_332;

import java.util.*;

//Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
//
//        Note:
//
//        If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
//        All airports are represented by three capital letters (IATA code).
//        You may assume all tickets form at least one valid itinerary.
//        Example 1:
//
//        Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//        Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
//        Example 2:
//
//        Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//        Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
//        Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
//        But it is larger in lexical order.
public class Solution {
    Map<String,PriorityQueue<String>> map;
    LinkedList<String> path;
    public List<String> findItinerary(String[][] tickets) {//обычный дфс но вместо списка смежности используем приоритетную очередь для лексического сортирования
        map = new HashMap<>();
        path = new LinkedList<>();
        for(String[] ticket :tickets){
            map.putIfAbsent(ticket[0],new PriorityQueue<>());
            map.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");//начинаем с jfk
        return path;
    }

    public void dfs(String departure){
        PriorityQueue<String> adj = map.get(departure);
        while (adj!=null&&!adj.isEmpty()){
            dfs(adj.poll());//для каждой смежной запускаем дфс

        }
        path.addFirst(departure);//в начало вставляем последний аэропорт
    }
}
