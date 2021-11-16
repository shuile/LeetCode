package cn.shui.order;

/**
 * @author shui.
 * @date 2021/11/15.
 * @time 11:46.
 * 灯泡开关
 */
public class L319 {

    public static void main(String[] args) {
        L319 test = new L319();
        test.bulbSwitch(3);
    }

    // 超出时限
    public int bulbSwitch(int n) {
        boolean[] flag = new boolean[n];
        for (int i = 1; i <= n; i++) {
            int j = i - 1;
            while (j < n) {
                flag[j] = !flag[j];
                j += i;
            }
        }
        int ans = 0;
        for (boolean b : flag) {
            ans += b ? 1 : 0;
        }
        return ans;
    }

    // 数学
    public int bulbSwitch2(int n) {
        return (int) Math.sqrt(n + 0.5);
    }
}
