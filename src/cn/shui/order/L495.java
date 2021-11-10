package cn.shui.order;

/**
 * @author shui.
 * @date 2021/11/10.
 * @time 09:20.
 * 提莫攻击
 */
public class L495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length < 1) {
            return 0;
        }
        if (timeSeries.length == 1) {
            return duration;
        }
        int pre = 0, ans = 0;
        for (int num : timeSeries) {
            if (num >= pre) {
                ans += duration;
                pre = num + duration;
            } else {
                if (num + duration > pre) {
                    ans += num + duration - pre;
                    pre = num + duration;
                }
            }
        }
        return ans;
    }
}
