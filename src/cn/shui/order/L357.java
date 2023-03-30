package cn.shui.order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyiting on 2023/3/30
 * 统计各位数字都不同的数字个数
 */
public class L357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        List<String> total = new ArrayList<>(){{
            add("0");
            add("1");
            add("2");
            add("3");
            add("4");
            add("5");
            add("6");
            add("7");
            add("8");
            add("9");
        }};
        List<String> temp = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < 10; j++) {
                for (String s : total) {
                    if (i - s.length() == 2) {
                        if (!s.contains("" + j) && !s.contains("0")) {
                            temp.add(j + "0" + s);
                        }
                    }
                    if (i - s.length() == 1) {
                        if (!s.contains("" + j)) {
                            temp.add(j + s);
                        }
                    }
                }
            }
            total.addAll(temp);
            temp.clear();
        }
        return total.size();
    }

    /**
     * 排列组合
     */
    public int countNumbersWithUniqueDigits2(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int ans = 10, cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur *= 9 - i;
            ans += cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        L357 test = new L357();
        System.out.println(test.countNumbersWithUniqueDigits(3));
    }
}
