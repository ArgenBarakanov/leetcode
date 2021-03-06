package math.leetcode_43;

//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
//
//        Example 1:
//
//        Input: num1 = "2", num2 = "3"
//        Output: "6"
//        Example 2:
//
//        Input: num1 = "123", num2 = "456"
//        Output: "56088"
public class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int res[] = new int[n+m];//храним информацию здесь
        for(int i = n-1;i>=0;i--)
        {
            for(int j = m-1;j>=0;j--)
            {
                int d1 = num1.charAt(i)-'0';
                int d2 = num2.charAt(j)-'0';
                res[i+j+1] += d1*d2;//по разрядам суммируем и кладем в нужную  ячейку
            }
        }
        int carry = 0;
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] += carry;// если есть двузначное число то берем по остатку на 10
            int temp = res[i]%10;
            carry = res[i]/10;
            res[i] = temp;
        }
        StringBuilder builder = new StringBuilder();
        for(Integer i:res)
        {
            builder.append(i);
        }

        while(builder.length()>0&&builder.charAt(0)=='0')builder.deleteCharAt(0);
        return builder.length()==0?"0":builder.toString();
    }

    public static void main(String[] args){
        String s1 = "123";
        String s2 = "456";
        Solution solution = new Solution();
        solution.multiply2(s1,s2);
    }

    public String multiply2(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        for(int i = num1.length() - 1; i >= 0; i--){
            for(int j = num2.length() - 1; j >= 0; j--){
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                res[i + j + 1] += n1 * n2;
            }
        }
        int carry = 0;
        for(int i = res.length - 1; i >= 0; i--) {
            int temp = (res[i] + carry) % 10;
            carry = (res[i] + carry) / 10;
            res[i] = temp;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(Integer i: res){
            stringBuilder.append(i);
        }
        while (stringBuilder.length() >0 &&stringBuilder.charAt(0) == '0') stringBuilder.deleteCharAt(0);
        return stringBuilder.toString();
    }
}
