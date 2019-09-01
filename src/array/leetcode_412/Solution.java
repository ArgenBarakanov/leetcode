package array.leetcode_412;

import java.util.ArrayList;
import java.util.List;

//Write a program that outputs the string representation of numbers from 1 to n.
//
//        But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        int i=1;
        while(i<=n){
            if(i%15==0){
                list.add("FizzBuzz");
                i++;
                continue;
            }else if(i%5==0){
                list.add("Buzz");
                i++;
                continue;
            }else if(i%3==0){
                list.add("Fizz");
                i++;
                continue;
            }else{
                list.add(i+"");
                i++;
            }
        }
        return list;
    }
}
