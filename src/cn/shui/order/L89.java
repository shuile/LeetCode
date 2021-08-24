package cn.shui.order;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shui.
 * @date 2021/8/24.
 * @time 10:20.
 * 格雷编码
 */
public class L89 {

    // 不知道为何出错
    public List<Integer> grayCode1(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        if (n <= 0) {
            return ans;
        }
        int max = (int) (Math.pow(2, n) - 1);
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= max; i++) {
            set.add(i);
        }
        for (int i = 0; i < max; i++) {
            for (int j : set) {
                if (isDiffOne(ans.get(ans.size() - 1), j, n)) {
                    ans.add(j);
                    set.remove(j);
                    break;
                }
            }
        }
        return ans;
    }

    private boolean isDiffOne(int a, int b, int n) {
        int c = a ^ b;
        int oneCount = 0;
        while (n > 0) {
            if ((c & 1) == 1) {
                oneCount++;
            }
            c = c >> 1;
            n--;
        }
        return oneCount == 1;
    }

    private List<Integer> grayCode2(int n) {
        List<Integer> ans = new ArrayList<Integer>() {{
            add(0);
        }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = ans.size() - 1; j >= 0; j--) {
                ans.add(head + ans.get(j));
            }
            head <<= 1;
        }
        return ans;
    }
}
