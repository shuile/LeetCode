package cn.shui.order;

import java.util.*;

/**
 * Created by chenyiting on 2022/10/13
 * 多数元素II
 */
public class L229 {
    public List<Integer> majority(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int max = nums.length / 3;
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() >= max) {
                ans.add(entry.getKey());
            }
        }
        return ans;
    }

    public List<Integer> majority2(int[] nums) {
        int ele1 = 0, ele2 = 0, vote1 = 0, vote2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && ele1 == num) {
                vote1++;
            } else if (vote2 > 0 && ele2 == num) {
                vote2++;
            } else if (vote1 == 0) {
                ele1 = num;
                vote1++;
            } else if (vote2 == 0) {
                ele2 = num;
                vote2++;
            } else {
                vote1--;
                vote2--;
            }
        }
        int cnt1 = 0, cnt2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && ele1 == num) {
                cnt1++;
            }
            if (vote2 > 0 && ele2 == num) {
                cnt2++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (vote1 > 0 && cnt1 > nums.length / 3) {
            ans.add(ele1);
        }
        if (vote2 > 0 && cnt2 > nums.length / 3) {
            ans.add(ele2);
        }
        return ans;
    }
}
