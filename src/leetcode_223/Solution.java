package leetcode_223;
//Find the total area covered by two rectilinear rectangles in a 2D plane.
//
//        Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {//тупо нарисуй два прямоугольника и подумой 
        int area1 = (C-A)*(D-B);
        int area2 = (G-E)*(H-F);
        if(B>=H||A>=G||C<=E||D<=F) return area1+area2;
        int length = Math.min(C,G)-Math.max(A,E);
        int height = Math.min(D,H)-Math.max(B,F);
        return area1+area2-length*height;
    }
}
