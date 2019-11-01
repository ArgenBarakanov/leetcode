package algorithms.dynamic.n_queens;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
короче описывать долго
в каждом ряду в каждой колонке ставим ферзя и рекурсивно идем на следующий уровень.
прежде чем поставить ферзя на клетку необходимо убедиться что эта клетка не находится под атакой
в данном коде по горизонтали мы отлично избегаем
с колонками проверяем текущюю ординату с предыдущей.
диагонали проверяем которые идут слева направо и справа налево. если x-i==y-j или x-i == j-y то мы на одной диагонали.
 */
public class Solution {
    public static void main(String[] args){
        Solution s = new Solution();
        s.solveNQueens(8);
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(board, 0, res);
        return res;
    }
    public void dfs(char[][] board,int row,List<List<String>> res){
     if(row==board.length){
         res.add(construct(board));
         return;
     }
     for(int col = 0; col<board.length;col++){
          if(save(board,row,col)){
              board[row][col]='Q';
              dfs(board,row+1,res);
              board[row][col]='.';
          }
     }
    }

    public boolean save(char[][] board,int x,int y){
        for(int i=0;i<x;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='Q'&&(x+j==y+i||x+y==i+j||y==j))return false;
            }
        }
        return true;
    }

    public List<String> construct(char[][] board){
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
