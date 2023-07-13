package cn.shui.order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyiting on 2023/7/13
 */
public class L371 {
    // 超时
    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        List<Integer> tmp = new ArrayList<>();
        int flag = 0;
        while (a != 0 || b != 0) {
            int t1 = a & 1;
            int t2 = b & 1;
            if (t1 == 1) {
                if (t2 == 1) {
                    if (flag == 1) {
                        tmp.add(0, 1);
                    } else {
                        tmp.add(0, 0);
                    }
                    flag = 1;
                } else {
                    if (flag == 1) {
                        tmp.add(0, 0);
                    } else {
                        tmp.add(0, 1);
                    }
                }
            } else {
                if (t2 == 1) {
                    if (flag == 1) {
                        tmp.add(0, 0);
                    } else {
                        tmp.add(0, 1);
                    }
                } else {
                    tmp.add(0, flag);
                    flag = 0;
                }
            }
            a >>= 1;
            b >>= 1;
        }
        if (flag == 1) {
            tmp.add(0, 1);
        }
        int ans = 0;
        for (int i : tmp) {
            ans <<= 1;
            ans ^= i;
        }
        return ans;
    }

    public int getSum2(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a ^= b;
            b = carry;
        }
        return a;
    }
}
