package algorithms.dynamic.range_sum_query;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Solution {
    //leetcode 303
    public static void main(String[] args){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String s = dateFormat.format("10.10.2020");
        System.out.println(s);
    }

    public static void foo(Dog dog){
        dog.name = "Max";
        dog = new Dog();
        dog.name = "Sharik";
    }
}
class Dog {
    public String name;
}
