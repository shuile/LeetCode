package cn.shui.order;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenyiting on 2023/3/16
 * 比特位计数
 */
public class L338 {

    private Map<Integer, Integer> map = new HashMap<>(){{
       put(0, 0);
       put(1, 1);
       put(2, 1);
    }};

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = n; i >= 0; i--) {
            ans[i] = help(i);
        }
        return ans;
    }

    private int help(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int one = 0, save = n;
        while (n > 0) {
            one += n & 1;
            n >>= 1;
            if (map.containsKey(n)) {
                one += map.get(n);
                break;
            }
        }
        map.put(save, one);
        return one;
    }

    // Brian Kernighan 算法
    public int[] countBits2(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = count(i);
        }
        return ans;
    }

    private int count(int n) {
        int one = 0;
        while (n > 0) {
            n &= n - 1;
            one++;
        }
        return one;
    }

    public static void main(String[] args) {
        L338 test = new L338();
        System.out.println(Arrays.toString(test.countBits(5)));;
    }
}
