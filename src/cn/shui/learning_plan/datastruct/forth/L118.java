package cn.shui.learning_plan.datastruct.forth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/8/19.
 * @time 09:53.
 * 杨辉三角
 */
public class L118 {
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) {
            return ans;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ans.add(new ArrayList<>(list));
        if (numRows == 1) {
            return ans;
        }
        list.add(1);
        ans.add(new ArrayList<>(list));
        if (numRows == 2) {
            return ans;
        }
        List<Integer> temp;
        for (int i = 2; i < numRows; i++) {
            temp = ans.get(i - 1);
            list.clear();
            list.add(1);
            for (int j = 1; j < temp.size(); j++) {
                list.add(temp.get(j - 1) + temp.get(j));
            }
            list.add(1);
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }

    // 数学
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.clear();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            ans.add(new ArrayList<>(row));
        }
        return ans;
    }
}
