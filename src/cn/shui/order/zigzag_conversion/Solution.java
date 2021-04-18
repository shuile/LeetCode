package cn.shui.order.zigzag_conversion;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));

        System.out.println(convert2(s, numRows));
    }

    /**
     * 方法2
     * @param s
     * @param numRows
     * @return
     */
    private static String convert2(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    /**
     * 方法1
     * @param s
     * @param numRows
     * @return
     */
    private static String convert(String s, int numRows) {
        if (s == null || s.length() < 1) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        int block = s.length() / (2 * numRows - 2);
        if ((s.length() / (2.0 * numRows - 2)) > block) {
            block++;
        }
        String ans = "";
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < block; j++) {
                int t1 = i + j * (2 * numRows - 2);
                if (t1 >= s.length()) {
                    continue;
                }
                ans += s.charAt(t1);
                if (i == 0 || i == (numRows - 1)) {
                    continue;
                }
                int t2 = t1 + 2 * (numRows - 1 - i);
                if (t2 >= s.length()) {
                    continue;
                }
                ans += s.charAt(t2);
            }
        }
        return ans;
    }
}
