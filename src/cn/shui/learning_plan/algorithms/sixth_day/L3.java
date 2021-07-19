package cn.shui.learning_plan.algorithms.sixth_day;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shui.
 * @date 2021/7/19.
 * @time 13:53.
 * 无重复字符的最长子串
 */
public class L3 {

    public static void main(String[] args) {
        String s = "0123456789";
        int i = s.indexOf("4");
        System.out.println(s.substring(i + 1, s.length()));
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        if (sb.toString().contains(s.charAt(5) + "")) {

        }
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int max = 0;
        StringBuilder sb = new StringBuilder();
        String chStr;
        for (int i = 0; i < s.length(); i++) {
            chStr = s.charAt(i) + "";
            if (sb.toString().contains(chStr)) {
                String temp = sb.toString();
                max = Math.max(max, temp.length());
                sb = new StringBuilder(temp.substring(temp.indexOf(chStr) + 1));
            }
            sb.append(chStr);
        }
        return Math.max(max, sb.toString().length());
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        // 哈希集合，记录每个字符是否出现过
        Set<Character> set = new HashSet<>();
        // 右指针，初始值为-1，相当于我们在字符串的左边界的左侧,还没有开始移动
        int rk = -1, ans = 0;
        int len = s.length();
        // 枚举左指针的位置，初始值隐性地表示为-1
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < len && !set.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                set.add(s.charAt(rk + 1));
                rk++;
            }
            // 第i到rk格字符是一个极长的无重复字符串
            ans = Math.max(ans, set.size());
        }
        return ans;
    }
}
