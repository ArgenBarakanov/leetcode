package leetcode_200;
//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
//        Example 1:
//
//        Input:
//        11110
//        11010
//        11000
//        00000
//
//        Output: 1
public class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0)
            return 0;
        int n = grid.length;
        int m = grid[0].length;
        int count =0;
        for(int i=0; i<n;i++)
        {
            for(int j =0;j<m;j++)//для каждой ячейки проверяем являеется ли она сушей. если да то превращаем ее в воду и всех ее соседей посредством рекурсией и увеличиваем счетчик
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    markNotZeroes(i,j,grid,n,m);
                }
            }
        }
        return count;
    }
    public void markNotZeroes(int i,int j,char[][] grid,int n,int m){
        if(i<0||j<0||i>n-1||j>m-1||grid[i][j]=='0')return;
        grid[i][j]='0';
        markNotZeroes(i+1,j,grid,n,m);
        markNotZeroes(i-1,j,grid,n,m);
        markNotZeroes(i,j+1,grid,n,m);
        markNotZeroes(i,j-1,grid,n,m);
    }
}
