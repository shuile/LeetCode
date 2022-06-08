package cn.shui.labuladong;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenyiting on 2022/6/8
 * 连续数组
 */
public class L525 {

    // 前缀和 + 哈希表
    public int findMaxLength(int[] nums) {
        int ans = 0, counter = 0, len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(counter, -1);
        for (int i = 0; i < len; i++) {
            counter += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(counter)) {
                ans = Math.max(ans, i - map.get(counter));
            } else {
                map.put(counter, i);
            }
        }
        return ans;
    }
}
