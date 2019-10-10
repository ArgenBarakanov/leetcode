package algorithms.string_primitive_integer.partition_to_k_equal_sum;

import java.util.stream.IntStream;

public class Solution {
    public boolean canPartitionKSubsets(int[] a, int k) {
        int sum = IntStream.of(a).sum();
        return k != 0 && sum % k == 0 && canPartition(0, a, new boolean[a.length], k, 0, sum / k);
    }

    boolean canPartition(int start, int[] a, boolean[] seen, int k, int sum, int target) {
        if (k == 1) return true;//если дошли до k==1  то мы уже имеем 3 подмножества с нужной суммой и следовательно в остатке тоже
        //дает сумму которая нам нужна
        if (sum == target)//если сумма равна нужной то ищем следующее подмножество
            return canPartition(0, a, seen, k - 1, 0, target);
        for (int i = start; i < a.length; i++)
            if (!seen[i]) {//если это уже в каком то подмножестве то не берем его в расчет
                seen[i] = true;
                if (canPartition(i + 1, a, seen, k, sum + a[i], target))
                    return true;
                seen[i] = false;
            }
        return false;
    }
}
