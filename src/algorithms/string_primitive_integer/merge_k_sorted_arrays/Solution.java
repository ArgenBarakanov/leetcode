package algorithms.string_primitive_integer.merge_k_sorted_arrays;

import java.util.*;

public class Solution {
    public  List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays){
        List<Integer> result = new ArrayList<>();// вернем этот лист
        Queue<ArrayEntry> minHeap = new PriorityQueue<>(
                ((int) sortedArrays.size()), new Comparator<ArrayEntry>() {
            @Override
            public int compare(ArrayEntry o1 , ArrayEntry o2) {
                return Integer.compare(o1.value , o2.value);
            }
        });//куча где хранятся элементы от меньшего к большему
        List<Iterator<Integer>> iterators = new ArrayList<>(sortedArrays.size());//итераторы нужны чтоб знать из какого массива был вытащен элемент
        for(List<Integer> array : sortedArrays){
            iterators.add(array.iterator());// из каждого массива достаем итератор
        }
        for(int i = 0; i < iterators.size(); i++){//кладем в кучу по первому элементу из массивов
            if(iterators.get(i).hasNext()){
                minHeap.add(new ArrayEntry(iterators.get(i).next(), i));
            }
        }
        while(!minHeap.isEmpty()){

            // вытащили минимальный
            ArrayEntry ejectedMinItem = minHeap.poll();

            // добавили его в результат
            result.add(ejectedMinItem.value);

            // проверяем есть ли в массиве из которого мы извлекли минимум еще элементы.если есть то суем следующий в кучу
            if(iterators.get(ejectedMinItem.arrayId).hasNext()){
                minHeap.add(new ArrayEntry(iterators.get(ejectedMinItem.arrayId).next(), ejectedMinItem.arrayId));
            }

        }

        return result;
    }
}
class ArrayEntry{
    public int value;
    public int arrayId;

    public ArrayEntry(int value, int arrayId) {
        this.value = value;
        this.arrayId = arrayId;
    }
}
