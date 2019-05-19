package graph.leetcode_133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.
//        Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        HashMap<Node , Node> map = new HashMap<>();
        return helper(node , map);//dfs
    }

    public Node helper(Node node , HashMap<Node , Node> map) {
        if(node == null) {//если нул то вернем нул
            return null;
        }
        if(map.containsKey(node)) {
            return map.get(node);//если в карте уже есть этот узел то вернем его клона
        }
        Node newNode = new Node(node.val , new ArrayList<>());
        map.put(node , newNode);
        for(Node child: node.neighbors) {
            newNode.neighbors.add(helper(child , map));
        }
        return newNode;
    }
}
