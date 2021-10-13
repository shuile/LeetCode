package cn.shui.learning_plan.offer.tenth;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/10/13.
 * @time 10:59.
 */
public class Offer48 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb = new StringBuilder(new StringBuilder("aa"));
        System.out.println(sb.toString());
        Offer48 test = new Offer48();
        test.lengthOfLongestSubstring("aabaab!bb");
        System.out.println(test.lengthOfLongestSubstring3("aaaab"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        int max = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            String temp = s.substring(i, i + 1);
            if (sb.toString().contains(temp)) {
                sb = new StringBuilder(sb.substring(sb.indexOf(temp) + 1));
            }
            sb.append(temp);
            max = Math.max(max, sb.length());
        }
        return max;
    }

    // 动态规划 + 哈希表
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1);
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }

    // 动态规划 + 线性遍历
    public int lengthOfLongestSubstring3(String s) {
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = j - 1;
            while (i >= 0 && s.charAt(i) != s.charAt(j)) {
                i--; // 线性查找i
            }
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp);
        }
        return res;
    }

    // 双指针 + 哈希表
    public int lengthOfLongestSubstring4(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (dic.containsKey(s.charAt(j))) {
                i = Math.max(i, dic.get(s.charAt(j)));  // 更新左指针
            }
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }
}
