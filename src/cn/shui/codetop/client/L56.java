package cn.shui.codetop.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by chenyiting on 2022/3/30
 * 合并区间
 */
public class L56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return ans.toArray(new int[][]{});
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        ans.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            int[] temp = ans.get(ans.size() - 1);
            if (intervals[i][0] > temp[1]) {
                ans.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                temp[1] = Math.max(temp[1], intervals[i][1]);
                ans.set(ans.size() - 1, temp);
            }
        }
        return ans.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        L56 test = new L56();
        int[][] merge = test.merge(intervals);
        System.out.println(Arrays.toString(merge));
        for (int i = 0; i < merge.length; i++) {
            System.out.println(Arrays.toString(merge[i]));;
        }
    }
}
