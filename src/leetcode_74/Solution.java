package leetcode_74;

//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
// Example 1:
//
// Input:
// matrix = [
// [1, 3, 5, 7],
// [10, 11, 16, 20],
// [23, 30, 34, 50]
// ]
// target = 3
// Output: true
public class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return false;
        int mas = searchMatrix2(matrix,target);//щем нужную строку


        if(mas==-1)
            return false;//ни в одной строчке нет числа
        int low =0, high = matrix[mas].length-1;
        int[] arr = matrix[mas];//берем нужную строку массива и все тот же бинарный поиск

        while(low<=high)
        {
            int mid = (low+high)/2;
            if(arr[mid] == target)
                return true;
            else if(arr[mid]<target)
                low=mid+1;
            else
                high = mid-1;
        }
        return false;
    }
    public static int searchMatrix2(int[][] matrix, int target) {//бинарный поиск
        int low =0,high = matrix.length-1;
        while(low<=high)
        {
            int mid = (low+high)/2;

            if(matrix[mid][0]<=target&&matrix[mid][matrix[0].length-1]>=target)
                return mid;
            else if(matrix[mid][0]>target)
                high = mid-1;
            else if(matrix[mid][matrix[0].length-1]<target)
                low=mid+1;
        }
        return -1;
    }
}