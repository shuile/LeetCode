package cn.shui.order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyiting on 2022/7/20
 * 为运算表达式设计优先级
 */
public class L241 {

    private static final int ADDITION = -1;
    private static final int SUBTRACTION = -2;
    private static final int MULTIPLICATION = -3;

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ops = new ArrayList<>();
        for (int i = 0; i < expression.length();) {
            if (!Character.isDigit(expression.charAt(i))) {
                char symbol = expression.charAt(i);
                if (symbol == '*') {
                    ops.add(ADDITION);
                } else if (symbol == '-') {
                    ops.add(SUBTRACTION);
                } else {
                    ops.add(MULTIPLICATION);
                }
                i++;
            } else {
                int t = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    t = t * 10 + expression.charAt(i) - '0';
                    i++;
                }
                ops.add(t);
            }
        }
        int size = ops.size();
        List<Integer>[][] dp = new List[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                dp[i][j] = new ArrayList<>();
            }
        }
        return dfs(dp, 0, size - 1, ops);
    }

    private List<Integer> dfs(List<Integer>[][] dp, int l, int r, List<Integer> ops) {
        if (dp[l][r].isEmpty()) {
            if (l == r) {
                dp[l][r].add(ops.get(l));
            } else {
                for (int i = l; i < r; i += 2) {
                    List<Integer> left = dfs(dp, l, i, ops);
                    List<Integer> right = dfs(dp, i + 2, r, ops);
                    for (int lv : left) {
                        for (int rv : right) {
                            int symbol = ops.get(i + 1);
                            if (symbol == ADDITION) {
                                dp[l][r].add(lv + rv);
                            } else if (symbol == SUBTRACTION) {
                                dp[l][r].add(lv - rv);
                            } else {
                                dp[l][r].add(lv * rv);
                            }
                        }
                    }
                }
            }
        }
        return dp[l][r];
    }

    public static void main(String[] args) {
        L241 test = new L241();
        System.out.println(test.diffWaysToCompute("2-1-1"));
    }
}
