package cn.shui.learning_plan.offerII;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/12/30.
 * @time 11:27.
 * 生成匹配的括号
 */
public class Offer085 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        help(n, n, "", ans);
        return ans;
    }

    private void help(int left, int right, String str, List<String> ans) {
        if (left == 0 && right == 0) {
            ans.add(str);
            return;
        }
        if (left > 0) {
            help(left - 1, right, str + "(", ans);
        }
        if (right > left) {
            help(left, right - 1, str + ")", ans);
        }
    }
}
