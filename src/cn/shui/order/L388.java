package cn.shui.order;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by chenyiting on 2025/2/10
 * Longest Absolute File Path
 */
public class L388 {
    public int lengthLongestPath(String input) {
        int ans = 0;
        if (input == null || input.length() == 0) {
            return ans;
        }
        int len = input.length();
        int[] dp = new int[len];
        int start = 0;
        String tmp;
        while (start < len) {
            if (input.substring(start, start + 1).equals("\n")) {
                start++;
                continue;
            }
            int tabNum = 0;
            if (input.substring(start, start + 1).equals("\t")) {
                while (input.substring(start, start + 1).equals("\t")) {
                    tabNum++;
                    start++;
                }
            }
            int end = start;
            for (; end < len; end++) {
                if (input.charAt(end) == '\n' || input.charAt(end) == '\t') {
                    break;
                }
            }
            tmp = input.substring(start, end);
            if (tmp.contains(".")) {
                int pathLen = 0;
                for (int i = 0; i < tabNum; i++) {
                    pathLen += dp[i];
                }
                ans = Math.max(ans, pathLen + tmp.length() + tabNum);
            } else {
                dp[tabNum] = tmp.length();
            }
            start += tmp.length();
        }
        return ans;
    }

    /**
     *  遍历
     */
    public int lengthLongestPath3(String input) {
        int n = input.length();
        int pos = 0;
        int ans = 0;
        int[] level = new int[n + 1];
        while (pos < n) {
            // 检测当前文件的深度
            int depth = 1;
            while (pos < n && input.charAt(pos) == '\t') {
                pos++;
                depth++;
            }
            // 统计当前文件名的长度
            int len = 0;
            boolean isFile = false;
            while (pos < n && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                len++;
                pos++;
            }
            // 跳过换行符
            pos++;

            if (depth > 1) {
                len += level[depth - 1] + 1;
            }
            if (isFile) {
                ans = Math.max(ans, len);
            } else {
                level[depth] = len;
            }
        }
        return ans;
    }

    /**
     * 栈
     * @param input
     * @return
     */
    public int lengthLongestPath2(String input) {
        int n = input.length();
        int pos = 0;
        int ans = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        while (pos < n) {
            // 检测当前文件的深度
            int depth = 1;;
            while (pos < n && input.charAt(pos) == '\t') {
                pos++;
                depth++;
            }
            // 统计当前文件名的长度
            boolean isFile = false;
            int len = 0;
            while (pos < n && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                len++;
                pos++;
            }
            // 跳过当前的换行符
            pos++;

            while (stack.size() >= depth) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                len += stack.peek() + 1;
            }
            if (isFile) {
                ans = Math.max(ans, len);
            } else {
                stack.push(len);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        L388 test = new L388();
        System.out.println(test.lengthLongestPath2("file1.txt\nfile2.txt\nlongfile.txt"));
    }
}
