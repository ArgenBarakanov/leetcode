package leetcode_79;

//Given a 2D board and a word, find if the word exists in the grid.
//
// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
// Example:
//
// board =
// [
// ['A','B','C','E'],
// ['S','F','C','S'],
// ['A','D','E','E']
// ]
//
// Given word = "ABCCED", return true.
// Given word = "SEE", return true.
// Given word = "ABCB", return false.
public class Solution {
    static boolean[][] isVisited;
    public static boolean exist(char[][] board, String word) {
        isVisited = new boolean[board.length][board[0].length];
        for(int i =0;i<board.length;i++)//обход в глубину
        {
            for(int j = 0;j<board[0].length;j++)
            {
                if(word.charAt(0)==board[i][j]&&search(0,i,j,word,board))//если совпали первые буквы то начинаем обход.если обход удачный то вернем истину
                    return true;
            }
        }
        return false;
    }
    public static boolean search(int index,int i,int j ,String word, char[][] board){
        if(index==word.length())//если вышли за пределы слова то поиск уачный
            return true;
        if(i<0||i>board.length-1||j<0||j>board[0].length-1||isVisited[i][j]||board[i][j]!=word.charAt(index))//если индекс вылез за пределы или ранее посещали эту клетку или буква не равна той что надо то ложь
            return false;

        isVisited[i][j] = true;//помечаем как посещенную
        if(search(index+1,i+1,j,word,board)||search(index+1,i-1,j,word,board)||search(index+1,i,j+1,word,board)||
                search(index+1,i,j-1,word,board))//обход в 4 стороны
            return true;

        isVisited[i][j]=false;//если не нашли то восстанавливаем и вернем ложь
        return false;
    }
}
