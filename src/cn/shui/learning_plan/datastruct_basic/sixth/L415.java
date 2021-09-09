package cn.shui.learning_plan.datastruct_basic.sixth;

/**
 * @author shui.
 * @date 2021/9/9.
 * @time 09:59.
 * 字符串相加
 */
public class L415 {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() < 1) {
            return num2;
        }
        if (num2 == null || num2.length() < 1) {
            return num1;
        }
        int len1 = num1.length() - 1, len2 = num2.length() - 1, carry = 0;
        StringBuilder ans = new StringBuilder();
        while (len1 >= 0 || len2 >= 0) {
            int a = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int b = len2 >= 0 ? num2.charAt(len2) - '0' : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            sum %= 10;
            ans.append(sum);
            len1--;
            len2--;
        }
        if (carry == 1) {
            ans.append(carry);
        }
        return ans.reverse().toString();
    }
}
