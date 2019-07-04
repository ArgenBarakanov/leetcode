package array.leetcode_317;

import java.util.*;

public class Solution {
    public static void main(String...args){
        int[][] matrix = {
                {1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };
        int result = new Solution().shortestDistance(matrix);
        System.out.println(result);
    }
    int[][] distances;
    int[][] reach;
    int totalBuildings;

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int m = grid.length, n = grid[0].length;
        distances = new int[m][n];//расстояние до каждого здания
        reach = new int[m][n];//сколько зданий доступно из открытой точки

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                Point p = new Point(i, j, grid);
                if (p.isBuilding()) {//если точка является зданием
                    totalBuildings++;//увеличиваем количество зданий
                    bfs(p);//обход в ширину для каждого здания
                }
            }
        }

        int minDistance = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {//если можно из точки дотянуться до всех зданий то сравниваем
                if (reach[i][j] == totalBuildings) {
                    if (minDistance == -1) minDistance = distances[i][j];
                    else minDistance = Math.min(minDistance, distances[i][j]);
                }
            }
        }
        for(int[] mas:distances){
            for(int i:mas){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        return minDistance;
    }

    // http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
    private void bfs(Point p) {
        Set<Point> visited = new HashSet<>();//храним точки которые уже посетили
        visited.add(p);

        Queue<Point> q = new LinkedList<>();
        q.add(p);
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {//берем точку и если она свободна икрементируем количество зданий доступных и расстояния от этой точки
                Point curr = q.remove();
                if (curr.isFree()) {//и засовываем в очередь ближайших соседей
                    distances[curr.i][curr.j] += distance;
                    reach[curr.i][curr.j] += 1;
                }

                List<Point> neighbors = curr.getFreeNeighbors();
                for(Point neighbor : neighbors) {
                    if (!visited.contains(neighbor))  {
                        visited.add(neighbor);
                        q.add(neighbor);
                    }
                }
            }
            distance++;
        }
    }
}

class Point {
    public int i;
    public int j;
    public int m;
    public int n;
    public int[][] grid;

    public Point(int i, int j, int[][] grid) {
        this.i = i;
        this.j = j;
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
    }

    public List<Point> getFreeNeighbors() {
        List<Point> list = new ArrayList<>();
        if (i > 0) {
            Point p = new Point(i-1, j, grid);
            if (p.isFree()) list.add(p);
        }
        if (j > 0) {
            Point p = new Point(i, j-1, grid);
            if (p.isFree()) list.add(p);
        }
        if (i < m-1) {
            Point p = new Point(i+1, j, grid);
            if (p.isFree()) list.add(p);
        }
        if (j < n-1) {
            Point p = new Point(i, j+1, grid);
            if (p.isFree()) list.add(p);
        }
        return list;
    }

    public boolean isFree() {
        return grid[i][j] == 0;
    }

    public boolean isObstacle() {
        return grid[i][j] == 2;
    }

    public boolean isBuilding() {
        return grid[i][j] == 1;
    }

    @Override
    public int hashCode() {
        return i*797 + j*9997;
    }

    @Override
    public boolean equals(Object obj) {
        Point p = (Point)obj;
        return this.i == p.i && this.j == p.j;
    }
}
