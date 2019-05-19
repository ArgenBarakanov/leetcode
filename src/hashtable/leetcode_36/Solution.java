package hashtable.leetcode_36;


import java.util.HashSet;

public class Solution {
    //    Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
//
//    Each row must contain the digits 1-9 without repetition.
//    Each column must contain the digits 1-9 without repetition.
//    Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0 ;i<9;i++)
        {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cubs = new HashSet<>();
            for(int j = 0 ; j<9;j++)
            {
                if(board[i][j]!='.'&&!rows.add(board[i][j])) return false;//каждая строка и столбец
                if(board[j][i]!='.'&&!cols.add(board[j][i])) return false;
                int rowIndex = 3*(i/3)+j/3;
                int colIndex = 3*(i%3)+j%3;
                if(board[rowIndex][colIndex]!='.'&&!cubs.add(board[rowIndex][colIndex]))return false;//каждый квадрат.каждый квадрат слева направо сверху вниз

            }
        }
        return true;
    }
}