package cn.shui.learning_plan.offerII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author shui.
 * @date 2021/12/28.
 * @time 11:03.
 * 合并区间
 */
public class Offer074 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int[] interval : intervals) {
            if (list.get(list.size() - 1)[1] >= interval[0]) {
                if (list.get(list.size() - 1)[1] < interval[1]) {
                    list.get(list.size() - 1)[1] = interval[1];
                }
            } else {
                list.add(new int[]{interval[0], interval[1]});
            }
        }
        return list.toArray(new int[0][]);
    }
}
