package cn.shui.order;

/**
 * @author shui.
 * @date 2022/2/17.
 * @time 09:34.
 * 位1的个数
 */
public class L191 {
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            ans += n & 1;
            n >>>= 1;
        }
        return ans;
    }

    // 位运算优化
    public int hammingWeight2(int n) {
        int ans = 0;
        while (n != 0) {
            n &= n - 1;
            ans++;
        }
        return ans;
    }
}
