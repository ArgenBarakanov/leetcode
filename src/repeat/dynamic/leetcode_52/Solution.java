package repeat.dynamic.leetcode_52;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int totalNQueens(int n) {
        return solveNQueens(n).size();
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<>();
        dfs(board, res, 0);
        return res;
    }

    private void dfs(char[][] board, List<List<String>> res, int row) {
        if(row == board.length){
            res.add(construct(board));
            return;
        }
        for(int i = 0; i < board.length; i++){
            if(isSave(board,row,i)){
                board[row][i] = 'Q';
                dfs(board,res,row + 1);
                board[row][i] = '.';
            }
        }
    }

    private boolean isSave(char[][] board,  int x, int y) {
        for(int i = 0; i<x; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == 'Q' && (j == y || x + j == y + i || x + y == i + j))return false;
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
