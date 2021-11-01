package cn.shui.order;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shui.
 * @date 2021/11/1.
 * @time 07:53.
 * 分糖果
 */
public class L575 {
    public int distributeCandies(int[] candyType) {
        if (candyType == null || candyType.length < 1) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : candyType) {
            set.add(num);
        }
        return Math.min(set.size(), candyType.length / 2);
    }
}
