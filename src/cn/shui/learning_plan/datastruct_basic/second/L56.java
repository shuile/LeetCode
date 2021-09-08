package cn.shui.learning_plan.datastruct_basic.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author shui.
 * @date 2021/9/3.
 * @time 17:00.
 * 合并区间
 */
public class L56 {

    public static void main(String[] args) {
        int[][] intervals = {{5,2},{3,4}};
        int[] temp = {intervals[0][0], intervals[0][1]};
        System.out.println(Arrays.toString(temp));
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        intervals[0][0] = 5;
        intervals[0][1] = 6;
    }

    public int[][] merge1(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        int[] temp = null;
        for (int[] interval : intervals) {
            if (temp == null) {
                temp = interval;
                continue;
            }
            if (temp[0] > interval[1] || temp[1] < interval[0]) {
                list.add(new int[]{temp[0], temp[1]});
                temp = interval;
                continue;
            }
            temp[0] = Math.min(temp[0], interval[0]);
            temp[1] = Math.max(temp[1], interval[1]);
        }
        if (temp != null) {
            list.add(new int[]{temp[0], temp[1]});
        }
        int[][] realAns = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            realAns[i] = list.get(i);
        }
        return realAns;
    }

    // 排序
    public int[][] merge2(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
