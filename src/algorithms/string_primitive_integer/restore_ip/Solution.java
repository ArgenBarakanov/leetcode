package algorithms.string_primitive_integer.restore_ip;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> solutions = new ArrayList<String>();
        restoreIp(s, solutions, 0, "", 0);
        return solutions;
    }

    private void restoreIp(String ip, List<String> solutions, int idx, String restored, int count) {
        if (count > 4) return;//если уже у нас есть все четыре составляющие ip адреса то ловить нечего
        if (count == 4 && idx == ip.length()) solutions.add(restored);//если четыре составляющих и вся строка использована то кладем в результат

        for (int i=1; i<4; i++) {
            if (idx+i > ip.length()) break;//если мы уже перешли длину строки(это возможно если вся строка использована а мы все еще пытаемся генерировать подстроку для 4 части айпишника то мы просто прервемся)
            String s = ip.substring(idx,idx+i);
            if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) >= 256)) continue;//если подстрока невалидна(начинается с нуля или больше 256) то мы просто пропускаем этот вариант
            restoreIp(ip, solutions, idx+i, restored+s+(count==3?"" : "."), count+1);//идем дальше инкрементирую счетчик
        }
    }
}
