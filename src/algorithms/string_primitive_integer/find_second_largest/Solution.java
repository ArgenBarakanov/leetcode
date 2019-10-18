package algorithms.string_primitive_integer.find_second_largest;

public class Solution {
    public static int secondLargest(int arr[]) {

        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        if(arr.length<2){
            //массив меньше двух элементов. нет ответа
            return secondLargest;
        }
        for(int i = 0; i < arr.length; i++){
            /*
            если этот элемент больше чем первый максимум
            то его мы делаем первым наибольшим а первый вторым наибольшим

             */
            if (arr[i] > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = arr[i];
            }
            //иначе если элемент меньше чем первый но больше второго то и при этом он не равен наибольшему
            else if (arr[i] > secondLargest && arr[i] != firstLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}
