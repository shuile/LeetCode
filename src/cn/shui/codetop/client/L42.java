package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/3/25
 * 接雨水
 */
public class L42 {

    // 动态规划
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int len = height.length;
        int[] lMax = new int[len];
        int[] rMax = new int[len];
        int res = 0;
        lMax[0] = height[0];
        rMax[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            lMax[i] = Math.max(height[i], lMax[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            rMax[i] = Math.max(height[i], rMax[i + 1]);
        }
        for (int i = 1; i < len - 1; i++) {
            res += Math.min(lMax[i], rMax[i]) - height[i];
        }
        return res;
    }

    // 双指针
    public int trap2(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
