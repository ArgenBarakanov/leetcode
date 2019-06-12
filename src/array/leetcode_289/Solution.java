package array.leetcode_289;

public class Solution {
    public static void gameOfLife(int[][] board) {
        int[][] res = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int n = neihgbours(i,j,board);
                if(board[i][j]==1){
                    if(n==2||n==3)res[i][j]=1;
                }else {
                    if(n==3)res[i][j]=1;
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]=res[i][j];
            }
        }
    }
    public static int neihgbours(int ix,int iy,int[][] board){
        //System.out.println("for "+ix+" and "+iy);
        int count =0;
        for(int i=ix-1;i<=ix+1;i++){
            for(int j=iy-1;j<=iy+1;j++){

                if(i<0||i>board.length-1||j<0||j>board[0].length-1)continue;
                if(i==ix&&j==iy)continue;
                if(board[i][j]==1)count++;
                // System.out.print(i+" "+j+", ");
            }
        }
        //System.out.println(count+" neighbour ");

        return count;
    }
}
