package cn.shui.order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2022/2/10.
 * @time 10:14.
 * 最简分数
 */
public class L1447 {
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            ans.add("1/" + i);
            for (int j = 2; j < i; j++) {
                if (isSimplified(j, i)) {
                    ans.add(j + "/" + i);
                }
            }
        }
        return ans;
    }

    private boolean isSimplified(int fenzi, int fenmu) {
        for (int i = 2; i <= fenzi; i++) {
            if (fenzi % i == 0 && fenmu % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 数学
    public List<String> simplifiedFraction2(int n) {
        List<String> ans = new ArrayList<>();
        for (int denominator = 2; denominator <= n; denominator++) {
            for (int numerator = 1; numerator < denominator; numerator++) {
                if (gcd(numerator, denominator) == 1) {
                    ans.add(numerator + "/" + denominator);
                }
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
