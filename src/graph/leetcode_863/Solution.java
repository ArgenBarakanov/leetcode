package graph.leetcode_863;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        TreeNode head3 = new TreeNode(3);
        TreeNode head5 = new TreeNode(5);
        TreeNode head1 = new TreeNode(1);
        TreeNode head6 = new TreeNode(6);
        TreeNode head2 = new TreeNode(2);
        TreeNode head7 = new TreeNode(7);
        TreeNode head4 = new TreeNode(4);
        TreeNode head0 = new TreeNode(0);
        TreeNode head8 = new TreeNode(8);
        head3.left = head5;
        head3.right = head1;
        head5.left = head6;
        head5.right = head2;
        head2.left = head7;
        head2.right = head4;
        head1.left = head8;
        head1.right = head0;
        Solution solution = new Solution();
        Map<Integer, List<Integer>> map = new HashMap<>();
        solution.distanceK(head3,head5,2);
        System.out.println(map);
    }

    public void traverse(TreeNode parent, TreeNode current, Map<Integer, List<Integer>> map) {
        if (current == null) return;
        map.put(current.val, new ArrayList<>());
        if (parent != null) map.get(current.val).add(parent.val);
        if (current.left != null) map.get(current.val).add(current.left.val);
        if (current.right != null) map.get(current.val).add(current.right.val);
        traverse(current, current.left, map);
        traverse(current, current.right, map);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        traverse(null, root, map);
        List<Integer> res = new ArrayList<>();
        bfs(K, map, target.val, res);
        return res;
    }

    public void bfs(int k, Map<Integer, List<Integer>> map, int target, List<Integer> res) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int level = 0;
        queue.add(target);
        visited.add(target);
        while (!queue.isEmpty()) {
            if (level == k) break;
            List<Integer> temp = new ArrayList<>();
            while (!queue.isEmpty()) {
                map.get(queue.poll()).stream().filter(i -> !visited.contains(i)).forEach(
                        temp::add);
            }
            visited.addAll(temp);
            queue.addAll(temp);
            level++;
        }
        res.addAll(queue);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
