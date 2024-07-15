package cn.shui.order;

import java.util.Arrays;

/**
 * Created by chenyiting on 2024/7/16
 * Find Common Elements Between Two Arrays
 */
public class L2956 {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] order1 = new int[101];
        int[] order2 = new int[101];
        Arrays.fill(order1, 0);
        Arrays.fill(order2, 0);
        for (int num : nums1) {
            order1[num]++;
        }
        for (int num : nums2) {
            order2[num]++;
        }
        int ans1 = 0, ans2 = 0;
        for (int i = 0; i < 101; i++) {
            if (order1[i] > 0 && order2[i] > 0) {
                ans1 += order1[i];
                ans2 += order2[i];
            }
        }
        return new int[]{ans1, ans2};
    }
}
