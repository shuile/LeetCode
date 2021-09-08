package cn.shui.learning_plan.datastruct_basic.third;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/9/6.
 * @time 14:12.
 * 杨辉三角II
 */
public class L119 {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<Integer> getRow1(int rowIndex) {
        if (rowIndex < 0) {
            return null;
        }
        if (ans.size() >= rowIndex) {
            return ans.get(rowIndex - 1);
        }
        if (ans.size() == 0) {
            ans.add(new ArrayList<Integer>() {{
                add(1);
            }});
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> lastList;
        for (int i = ans.size(); i <= rowIndex; i++) {
            list.clear();
            lastList = ans.get(ans.size() - 1);
            int lastSize = lastList.size();
            list.add(1);
            for (int j = 1; j < lastSize; j++) {
                list.add(lastList.get(j - 1) + lastList.get(j));
            }
            list.add(1);
            ans.add(new ArrayList<>(list));
        }
        return ans.get(rowIndex);
    }

    // 递推
    public List<Integer> getRow2(int rowIndex) {
        List<List<Integer>> C = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(C.get(i - 1).get(j - 1) + C.get(i - 1).get(j));
                }
            }
            C.add(row);
        }
        return C.get(rowIndex);
    }

    // 递推优化
    public List<Integer> getRow3(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return pre;
    }

    // 进一步优化
    public List<Integer> getRow4(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add(0);
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }

    // 线性递推
    public List<Integer> getRow5(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            ans.add((int) ((long) ans.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return ans;
    }
}
