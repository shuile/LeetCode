package cn.shui.learning_plan.offerII;

/**
 * @author shui.
 * @date 2021/12/2.
 * @time 16:32.
 * 前n个数字二进制中1的个数
 */
public class Offer003 {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i < ans.length; i++) {
            int temp = i;
            int count = 0;
            while (temp != 0) {
                count += temp & 1;
                temp >>= 1;
            }
            ans[i] = count;
        }
        return ans;
    }

    // Brian Kernighan算法
    public int[] countBits2(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    private int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= x - 1;
            ones++;
        }
        return ones;
    }

    // 动态规划--最高有效位
    public int[] countBits3(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

    // 动态规划--最低有效位
    public int[] countBits4(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }

    // 动态规划--最低设置位
    public int[] countBits5(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }
}
