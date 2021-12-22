package cn.shui.learning_plan.offerII;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author shui.
 * @date 2021/12/21.
 * @time 13:43.
 * 值和下标之差都在给定的范围内
 */
public class Offer057 {
    // 超时
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        long a, b;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= i + k && j < len; j++) {
                a = nums[i];
                b = nums[j];
                if (Math.abs(a - b) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    // 滑动窗口 + 有序集合
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        int len = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            Long ceiling = set.ceiling((long) nums[i] - t);
            if (ceiling != null && ceiling <= (long) nums[i] + t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    // 桶
    public boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {
        int len = nums.length;
        Map<Long, Long> map = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < len; i++) {
            long id = getID(nums[i], w);
            if (map.containsKey(id)) {
                return true;
            }
            if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) {
                return true;
            }
            map.put(id, (long) nums[i]);
            if (i >= k) {
                map.remove(getID(nums[i - k], w));
            }
        }
        return false;
    }

    private long getID(long x, long w) {
        if (x >= 0) {
            return x / w;
        }
        return (x + 1) / w - 1;
    }
}
