package leetcode_63;

//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//        The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//        Now consider if some obstacles are added to the grids. How many unique paths would there be?
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        obstacleGrid[0][0]^=1;
        for(int i = 1;i<m;i++)
        {
            obstacleGrid[i][0]=obstacleGrid[i][0]==1?0:obstacleGrid[i-1][0];
        }
        for(int j=1;j<n;j++)
        {
            obstacleGrid[0][j]=obstacleGrid[0][j]==1?0:obstacleGrid[0][j-1];
        }
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                obstacleGrid[i][j]=obstacleGrid[i][j]==1?0:obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
            }
        }
        return obstacleGrid[m-1][n-1];//все понятно только там где препятсвие там нули как впредыдущем примере крч
    }
}