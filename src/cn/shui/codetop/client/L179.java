package cn.shui.codetop.client;

import java.util.Arrays;

/**
 * Created by chenyiting on 2022/4/16
 * 最大数
 */
public class L179 {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] strs = new String[len];
        for (int i = 0; i < len; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        StringBuilder ans = new StringBuilder();
        for (String str : strs) {
            if ("0".equals(str) && "0".equals(ans.toString())) {
                continue;
            }
            ans.append(str);
        }
        return ans.toString();
    }
}
