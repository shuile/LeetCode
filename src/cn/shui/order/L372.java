package cn.shui.order;

import java.util.Arrays;

/**
 * Created by chenyiting on 2023/7/17
 */
public class L372 {
    public int superPow(int a, int[] b) {
        if (b == null || b.length == 0) {
            return 1;
        }
        a %= 1337;
        if (b.length == 1) {
            if (b[0] < 2) {
                return b[0] == 0 ? 1 : a;
            }
        }
        int aTemp = (a * a) % 1337;
        int temp = 0;
        boolean lastOdd = b[b.length - 1] % 2 == 1;
        for (int i = 0; i < b.length; i++) {
            boolean hasRemain = (temp * 10 + b[i]) % 2 == 1;
            b[i] = (temp * 10 + b[i]) / 2;
            temp = hasRemain ? 1 : 0;
        }
        int res;
        if (b[0] == 0) {
            res = superPow(aTemp, Arrays.copyOfRange(b, 1, b.length));
        } else {
            res = superPow(aTemp, b);
        }
        if (lastOdd) {
            res = a * res % 1337;
        }
        return res;
    }

    public int superPow2(int a, int[] b) {
        int ans = 1;
        for (int i = b.length - 1; i>= 0; i--) {
            ans = (int) ((long) ans * pow(a, b[i]) % 1337);
            a = pow(a, 10);
        }
        return ans;
    }

    public int pow(int x, int n) {
        int res = 1;
        while (n != 0) {
            if (n % 2 == 1) {
                res = (int) ((long) res * x % 1337);
            }
            x = (int) ((long) x * x % 1337);
            n /= 2;
        }
        return res;
    }
}
