package cn.shui.order;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2022/2/16.
 * @time 20:52.
 */
public class L168 {
    public String convertToTitle(int columnNumber) {
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(i, (char) ('A' + i));
        }
        StringBuilder ans = new StringBuilder();
        while (columnNumber != 0) {
            ans.append(map.get(columnNumber % 27 - 1));
            columnNumber /= 27;
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        L168 test = new L168();
        System.out.println(test.convertToTitle(52));
    }

    // 数学
    public String convertToTitle1(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while (columnNumber > 0) {
            int a = (columnNumber - 1) % 26 + 1;
            ans.append((char) (a - 1 + 'A'));
            columnNumber = (columnNumber - a) / 26;
        }
        return ans.reverse().toString();
    }

    public String convertToTitle3(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;
            ans.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return ans.reverse().toString();
    }
}
