package cn.shui.learning_plan.datastruct_basic.seventh;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/9/9.
 * @time 10:43.
 * 划分字母区间
 */
public class L763 {
    // 贪心
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
