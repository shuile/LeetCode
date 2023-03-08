package cn.shui.order;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by chenyiting on 2023/3/8
 * 验证二叉树的前序序列化
 */
public class L331 {
    public boolean isValidSerialization(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        String[] str = s.split(",");
        int n = str.length;
        if ("#".equals(str[0]) && n > 1) {
            return false;
        }
        if ("#".equals(str[0])) {
            return true;
        }

        Deque<String> stack = new LinkedList<>();
        int i = 0;
        while (i < n) {
            String c = str[i];
            if (!"#".equals(c)) {
                // 遇到的不是'#'，直接入栈
                stack.push(c);
                i++;
            } else {
                if ("#".equals(stack.peek())) {
                    // 遇到'#'，当前栈顶也是'#'，弹出2个字符，压入1个'#'
                    stack.pop();
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                    // i 位置不动，继续处理当前字符'#'，循环判断是否依旧满足2）
                } else {
                    // 栈顶不是'#'，直接入栈
                    stack.push(c);
                    i++;
                }
            }
        }
        return stack.size() == 1 && "#".equals(stack.peek());
    }

    public boolean isValidSerialization2(String preorder) {
        int len = preorder.length();
        int i = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.push(1);
        char ch;
        while (i < len) {
            if (deque.isEmpty()) {
                return false;
            }
            ch = preorder.charAt(i);
            if (ch == ',') {
                i++;
            } else if (ch == '#') {
                int peek = deque.pop() - 1;
                if (peek > 0) {
                    deque.push(peek);
                }
                i++;
            } else {
                while (i < len && preorder.charAt(i) != ',') {
                    i++;
                }
                int peek = deque.pop() - 1;
                if (peek > 0) {
                    deque.push(peek);
                }
                deque.push(2);
            }
        }
        return deque.isEmpty();
    }

    /**
     * 空间优化
     * @param preorder
     * @return
     */
    public boolean isValidSerialization3(String preorder) {
        int len = preorder.length();
        int i = 0;
        int count = 1;
        char ch;
        while (i < len) {
            if (count == 0) {
                return false;
            }
            ch = preorder.charAt(i);
            if (ch == ',') {
                i++;
            } else if (ch == '#') {
                count--;
                i++;
            } else {
                while (i < len && preorder.charAt(i) != ',') {
                    i++;
                }
                count++;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        String s1 = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        L331 test = new L331();
        System.out.println(test.isValidSerialization(s1));
        ;
    }
}
